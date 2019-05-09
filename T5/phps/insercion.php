<?php
 
require 'operaciones.php';
 
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
 
    $body = json_decode(file_get_contents("php://input"), true);
   
    $retorno = Usuarios::insertarAlumno(
        $body['nombre'],
        $body['apellidos'],
        $body['correo']);
 
    if ($retorno) {
        print json_encode(
            array(
                'estado' => '1',
                'mensaje' => 'El usuario creado con exito'));
    } 
    else {
        print json_encode(
            array(
                'estado' => '2',
                'mensaje' => 'El usuario no se ha podido crear')
        );  
    }
}
?>