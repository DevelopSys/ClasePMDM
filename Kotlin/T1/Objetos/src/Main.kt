import model.Document
import model.Person
import model.Student

fun main() {

    val person: Person = Person(
        "Borja", "Martin",
        "123A", "correo@gmail.com"
    )
    person.mostrarDatos()

    val document = Document(theme = "Sport")
    val document1 = Document("Autor", "Sport")
    val document2 = Document("Autor", extension = 8)
    val document3 = Document("Autor", "sport", 8, "digital")

    val student: Student = Student(
        "Borja", "Martin",
        "123A", "correo@gmail.com", 123, 234
    )

    student.mostrarDatos()

    // crear un objeto de tipo documento que tenga los atributos
    // Autor
    // Tema
    // extension (int)
    // opcionalmente tiene un formato (string)

    // CREAR TAMBIEN EL CONSTRUCTOR VACIO
    // CREAR LOS MENOS CONSTRUCTORES POSIBLES

}