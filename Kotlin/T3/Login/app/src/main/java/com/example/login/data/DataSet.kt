package com.example.login.data

import com.example.login.model.Product
import com.example.login.model.User

class DataSet {

    // static
    companion object {
        // todos los elementos asociados a la clase y metodos
        private val listUser: ArrayList<User> = arrayListOf()
        private val listProduct: ArrayList<Product> = arrayListOf()

        fun initList(): Unit {
            listUser.add(User("admin", "admin", "admin@gmail.com", "admin", 0))
            listProduct.add(Product(1, "Producto1", 10.99, "Descripcion prueba 1", "https://cdn.dummyjson.com/product-images/beauty/essence-mascara-lash-princess/1.webp"))
            listProduct.add(Product(2, "Producto2", 20.99, "Descripcion prueba 2", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRyLe2rsZRLA3H-MxW--98gGF-jnF4yxnSSt8B1HizlKTRYQVcavqrvzVU&s=10"))
            listProduct.add(Product(3, "Producto3", 30.99, "Descripcion prueba 3", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT9SQ1-E11obZjrTukEj3MnWJd2JKklCAnTOo1NDoMM3A&s=10"))
            listProduct.add(Product(4, "Producto4", 40.99, "Descripcion prueba 4", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTVLlbSTA-lKFvPeEwo2YKmmoFECvBSSAhi5f25QftrM0iymqlelFSgbkFp&s=10"))

        }

        fun addUser(user: User): Boolean {
            // si no hay un usuaro con ese correo -> añades
            val exist = listUser.any { user.mail == it.mail }
            if (!exist) {
                listUser.add(user)
                return true
            }
            return false;
        }

        fun getLogin(mail: String, pass: String): User? {
            return listUser.find { mail == it.mail && pass == it.pass };
        }


    }
}