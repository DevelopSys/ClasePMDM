import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class FormPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text(
          "Formulario de inputs",
          style: TextStyle(color: Colors.white),
        ),
        backgroundColor: const Color(0xFF1B6B93),
        centerTitle: true,
      ),
      backgroundColor: const Color(0xFF4FC0D0),
      body: SafeArea(child: FormWidget()),
    );
  }
}

class FormWidget extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    // TODO: implement createState
    return _FormStateWodget();
  }
}

class _FormStateWodget extends State<FormWidget> {
  TextEditingController _controllerName = TextEditingController();
  TextEditingController _controllerPass = TextEditingController();
  TextEditingController _controllerPhone = TextEditingController();
  TextEditingController _controllerSurname = TextEditingController();
  TextEditingController _controllerMail = TextEditingController();
  bool mailExist = false;

  @override
  Widget build(BuildContext context) {
    // TODO: implement build

    return Padding(
      padding: const EdgeInsets.all(8.0),
      child: SingleChildScrollView(
        child: Column(
          children: [
            Text("Por favor introduce tus datos",
                style: TextStyle(fontSize: 20.0, color: Colors.white)),
            Padding(padding: EdgeInsets.all(10.0)),
            Container(
              margin: EdgeInsets.symmetric(vertical: 10.0, horizontal: 20.0),
              padding: EdgeInsets.symmetric(vertical: 30.0, horizontal: 30.0),
              decoration: BoxDecoration(
                  borderRadius: BorderRadius.circular(10.0),
                  color: const Color(0xFFA2FF86)),
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [
                  TextField(
                    onSubmitted: (String value) {
                      print(value);
                    },
                    controller: _controllerName,
                    cursorColor: Colors.blue,
                    decoration: const InputDecoration(
                        filled: true,
                        fillColor: Colors.white,
                        label: Text("Introduce tu nombre"),
                        border: OutlineInputBorder(),
                        prefixIcon: Icon(Icons.people)),
                  ),
                  Padding(padding: EdgeInsets.only(top: 10.0)),
                  TextField(
                    onSubmitted: (String value) {
                      print(value);
                    },
                    controller: _controllerSurname,
                    cursorColor: Colors.blue,
                    decoration: const InputDecoration(
                        filled: true,
                        fillColor: Colors.white,
                        label: Text("Introduce tu apellido"),
                        border: OutlineInputBorder(),
                        prefixIcon: Icon(Icons.people)),
                  ),
                  Padding(padding: EdgeInsets.only(top: 10.0)),
                  TextField(
                      controller: _controllerPhone,
                      keyboardType: TextInputType.phone,
                      cursorColor: Colors.blue,
                      decoration: const InputDecoration(
                          filled: true,
                          fillColor: Colors.white,
                          label: Text("Introduce tu telefono"),
                          border: OutlineInputBorder(),
                          prefixIcon: Icon(Icons.phone)),
                      maxLength: 9,
                      inputFormatters: <TextInputFormatter>[
                        FilteringTextInputFormatter.digitsOnly
                      ]),
                  Padding(padding: EdgeInsets.only(top: 10.0)),
                  TextField(
                    controller: _controllerPass,
                    cursorColor: Colors.blue,
                    decoration: const InputDecoration(
                        filled: true,
                        fillColor: Colors.white,
                        label: Text("Introduce tu password"),
                        border: OutlineInputBorder(),
                        prefixIcon: Icon(Icons.password)),
                    obscureText: true,
                  ),
                  Padding(padding: EdgeInsets.only(top: 10.0)),
                  TextField(
                    enabled: mailExist,
                    controller: _controllerMail,
                    cursorColor: Colors.blue,
                    decoration: const InputDecoration(
                        filled: true,
                        fillColor: Colors.white,
                        label: Text("Introduce tu correo"),
                        border: OutlineInputBorder(),
                        prefixIcon: Icon(Icons.mail)),
                    obscureText: true,
                  ),
                  Row(
                    children: [
                      Text("¿Tienes mail?"),
                      Checkbox(
                        value: mailExist,
                        onChanged: (bool? value) {
                          setState(() {
                            mailExist = value!;
                          });
                        },
                      )
                    ],
                  ),
                  ElevatedButton.icon(
                    onPressed: () {
                      sendData();
                    },
                    style: ElevatedButton.styleFrom(
                      backgroundColor: Color(0xFF4FC0D0),
                      foregroundColor: Colors.white,
                    ),
                    label: Text("Enviar"),
                    icon: Icon(Icons.send),
                  )
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }

  void sendData() {
    bool rellenos = _controllerPhone.text.length > 0 &&
        _controllerName.text.length > 0 &&
        _controllerPass.text.length > 0 &&
        _controllerSurname.text.length > 0;

    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(
        action: rellenos
            ? (SnackBarAction(
                label: 'Ver datos',
                onPressed: () {
                  ScaffoldMessenger.of(context).showSnackBar(
                    SnackBar(
                      content: Text(
                          "Nombre ${_controllerName.text!!} ${_controllerSurname.text} registrado con éxito"),
                      duration: const Duration(milliseconds: 3000),
                      padding: const EdgeInsets.symmetric(
                        horizontal: 8.0, // Inner padding for SnackBar content.
                      ),
                      behavior: SnackBarBehavior.floating,
                    ),
                  );
                },
              ))
            : null,
        content:
            _controllerName.text.length > 0 && _controllerPhone.text.length > 0
                ? const Text('Enviados los dátos éxito')
                : const Text('Por favor rellena todos los datos'),
        duration: const Duration(milliseconds: 3000),
        padding: const EdgeInsets.symmetric(
          horizontal: 8.0, // Inner padding for SnackBar content.
        ),
        behavior: SnackBarBehavior.floating,
      ),
    );
  }
}
