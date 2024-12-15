package com.example.tasktracker.service.impl

import com.example.tasktracker.database.entity.State
import com.example.tasktracker.database.repository.StateDao
import com.example.tasktracker.exception.AlreadyExistsException
import com.example.tasktracker.exception.NotFoundException
import com.example.tasktracker.model.request.StateRequest
import com.example.tasktracker.model.response.DeleteResponse
import com.example.tasktracker.model.response.StateResponse
import com.example.tasktracker.service.StateService
import com.example.tasktracker.util.StateMapper
import org.springframework.stereotype.Service

@Service
class StateServiceImpl(
    val dao: StateDao,
    val stateMapper: StateMapper,
): StateService {
    override fun getById(id: Long): State =
        dao.findById(id).orElseThrow {throw NotFoundException() }

    override fun getAll(): List<StateResponse> = dao.findAll().map {
        stateMapper.entityToResponse(it)
    }

    override fun create(stateRequest: StateRequest): StateResponse {
        for(state in dao.findAll()) {
            if (state.name == stateRequest.name)
                throw AlreadyExistsException()
        }
        val entity = State(
            name = stateRequest.name,
        )
        return stateMapper.entityToResponse(dao.save(entity))
    }

    override fun delete(id: Long): DeleteResponse {
        val entity = getById(id)
        dao.delete(entity)
        return DeleteResponse()
    }
}