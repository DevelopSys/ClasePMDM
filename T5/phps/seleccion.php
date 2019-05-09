<?php

	require 'operaciones.php';

	if ($_SERVER['REQUEST_METHOD'] == 'GET'){

		$consulta = Usuarios::getAlumnos();
		if($consulta){
			$datos['estado']=1;
			$datos['alumnos']=$consulta;

			print json_encode($datos);
		}
		else{
			# code...
			print json_encode(array(
                "estado" => 2,
                "mensaje" => "Ha ocurrido un error"
            ));
		}

	}	

?>