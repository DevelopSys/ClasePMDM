<?php
	require 'database.php';
	class Usuarios
	{
		function __construct()
		{
			
		}

		public static function getAlumnos(){
            $comando = 'SELECT * FROM ejemplo';
            $sentencia = Database::getInstance()->getDb()->prepare($comando);
            $sentencia ->execute();
            return $sentencia->fetchAll(PDO::FETCH_ASSOC);
        }

        public static function insertarAlumno($nombre,
            $apellidos,
            $correo)
        {

            $comando = 'INSERT INTO ejemplo (nombre, apellido, correo) VALUES (?,?,?)';


            $sentencia = Database::getInstance()->getDb()->prepare($comando);
            return $sentencia->execute(array(
                    $nombre,
                    $apellidos,
                    $correo));
        }


}
?>