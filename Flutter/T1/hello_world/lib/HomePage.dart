import 'package:flutter/material.dart';

class HomePage extends StatelessWidget {
  const HomePage({super.key, required this.title});

  final String title;

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Scaffold(
      appBar: AppBar(title: Text(title)),
      floatingActionButton: FloatingActionButton(
          onPressed: () => {}, child: const Icon(Icons.add)),
      body: Column(
        children: [
          Row(
            children: const [
              Text("Nombre"),
              Padding(padding: EdgeInsets.only(right: 10.0)),
              Expanded(
                  child: TextField(
                decoration: InputDecoration(
                    border: OutlineInputBorder(),
                    hintText: 'por favor introduce tu nombre'),
              ))
            ],
          ),
          Row(
            children: const [
              Text("Apellido"),
              Padding(padding: EdgeInsets.only(right: 10.0)),
              Expanded(
                  child: TextField(
                decoration: InputDecoration(
                    border: OutlineInputBorder(),
                    hintText: 'por favor introduce tu apellido'),
              )),
            ],
          ),
          Expanded(
              child: TextField(
            decoration: InputDecoration(
                border: OutlineInputBorder(),
                hintText: 'por favor introduce tu correo'),
          ))
        ],
      ),
    );
  }
}

/*Container(
padding: const EdgeInsets.all(20.0),
color: Colors.amber,
child: const Text("Contenedor principal"),
alignment: Alignment.topRight,
),*/
/*
* Column(
          children: [
            Text("Texto en posicion 1"),
            Icon(Icons.access_alarm),
            Text("Texto en posicion 2"),
            Expanded(
                child: Image.network(
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Google-flutter-logo.svg/2560px-Google-flutter-logo.svg.png"))
          ],
          mainAxisAlignment: MainAxisAlignment.center,
          //Center Row contents horizontally,
          crossAxisAlignment: CrossAxisAlignment.center
          //Center Row contents vertically,,
* */
