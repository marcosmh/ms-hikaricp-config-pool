package mx.com.hikaricp.app.apiservice.operaciones.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.hikaricp.app.apiservice.beans.Cadena;
import mx.com.hikaricp.app.apiservice.beans.Response;

@RestController
@RequestMapping("/api/operaciones")
public class OperacionesController {

	HttpStatus status = INTERNAL_SERVER_ERROR;

	@GetMapping
	public ResponseEntity<Response> obtenerTodos() {
		String msg = "Login 2.0:  Consulta ejecutada correctamente. Registros consultados: 10";
		Response res = new Response();
		if(true) {
			status = OK;
			res.setStatus(status.value());
			res.setOk(true);
			res.setMensaje(msg);
		} else {
			status = NOT_FOUND;
			res.setStatus(status.value());
			res.setOk(false);
			res.setMensaje("Login 2.0 :: Error al consultar");
		}
		return new ResponseEntity<>(res, status);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Response> obtenerPorId(@PathVariable Long id) {
		String msg = "Login 2.0:  Consulta ejecutada correctamente.  id= " + id;
		Response res = new Response();
		if(id != null) {
			status = OK;
			res.setStatus(status.value());
			res.setOk(true);
			res.setMensaje(msg);
		} else {
			status = NOT_FOUND;
			res.setStatus(status.value());
			res.setOk(false);
			res.setMensaje("Login 2.0 :: Error al consultar por id = "+id);
		}
		return new ResponseEntity<>(res, status);
	}


	@PostMapping
	public ResponseEntity<Response> guardar(@RequestBody Cadena valor) {
		String msg = "Login 2.0 :: Se ha guardado correctamente.";
		Response res = new Response();
		if(valor.getValor() != null) {
			status = CREATED;
			res.setStatus(status.value());
			res.setOk(true);
			res.setMensaje(msg);
		} else {
			status = NOT_FOUND;
			res.setStatus(status.value());
			res.setOk(false);
			res.setMensaje("Login 2.0 :: Error al guardar.");
		}
		return new ResponseEntity<>(res, status);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Response> actualizar(@PathVariable Long id) {
		String msg = "Login 2.0 :: Se ha actualizado correctamente.  id = " + id;
		Response res = new Response();
		if(id != null) {
			status = CREATED;
			res.setStatus(status.value());
			res.setOk(true);
			res.setMensaje(msg);
		} else {
			status = NOT_FOUND;
			res.setStatus(status.value());
			res.setOk(false);
			res.setMensaje("Login 2.0 :: Error al actualizar. id= "+id);
		}
		return new ResponseEntity<>(res, status);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Response> eliminar(@PathVariable Long id) {
		String msg = "Login 2.0 :: Eliminado correctamente.  id= " + id;
		Response res = new Response();
		if(id != null) {
			status = OK;
			res.setStatus(status.value());
			res.setOk(true);
			res.setMensaje(msg);
		} else {
			status = NOT_FOUND;
			res.setStatus(status.value());
			res.setOk(false);
			res.setMensaje("Login 2.0 :: Error al eliminar. id= "+id);
		}
		return new ResponseEntity<>(res, status);
	}


}
