import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

class MyHomePage extends StatelessWidget {
  const MyHomePage({super.key, required this.title});

  final String title;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(title: Text(title)),
        floatingActionButton: FloatingActionButton(
            onPressed: () {}, child: const Icon(Icons.comment)),
        body: Column(children: [
          const Center(child: Text("Primera app en Flutter")),
          FormState()
        ]));
  }
}

class FormState extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return _FormWidgetState();
  }
}

class _FormWidgetState extends State<FormState> {
  final nameController = TextEditingController();
  final numberController = TextEditingController();

  String _name = "";
  int _number = 0;

  _changeState() {
    setState(() {
      _name = nameController.text;
      _number = int.parse(numberController.text);
    });
  }
  _validateData(BuildContext context){
    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(
        content: Text("Nombre: $_name $_number")
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Container(
        padding: EdgeInsets.all(20),
        child: Column(children: [
          TextField(
            controller: nameController,
            decoration: const InputDecoration(
              border: OutlineInputBorder(),
              labelText: 'Introduce tu nombre',
            ),
          ),
          Padding(padding: EdgeInsets.fromLTRB(0, 10, 0, 10)),
          TextField(
            controller: numberController,
            decoration: const InputDecoration(
              border: OutlineInputBorder(),
              labelText: 'Introduce un número del 1 al 10',
            ),
          ),
          ElevatedButton(
              onPressed: () => {_changeState()},
              child: Text("Pulsar para añadir")),
          ElevatedButton(
              onPressed: () => {_validateData(context)},
              child: Text("Pulsar para validar")),
        ]));
  }
}
