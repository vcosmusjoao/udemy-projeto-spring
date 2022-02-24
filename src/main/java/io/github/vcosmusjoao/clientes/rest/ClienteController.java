package io.github.vcosmusjoao.clientes.rest;

import io.github.vcosmusjoao.clientes.model.entity.Cliente;
import io.github.vcosmusjoao.clientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente saveCliente(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @GetMapping("/{id}")
    public Cliente getCliente(@PathVariable Integer id){
        return clienteRepository
                .findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public void deleteCliente(@PathVariable Integer id){
        clienteRepository.findById(id)
                .map(cliente -> {
                    clienteRepository.delete(cliente);
                    return Void.TYPE;
                })
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public void atualizarCliente(@PathVariable Integer id,@RequestBody Cliente clienteAtualizado){
        clienteRepository.findById(id)
                .map(cliente -> {
                    clienteAtualizado.setId(cliente.getId());
                   return clienteRepository.save(clienteAtualizado);
                })
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
