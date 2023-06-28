import 'package:componentes/formPage.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

enum lenguage { Dart, Kotlin, Java, JavaScript, TypeScript }

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Componentes',
      theme: ThemeData(primarySwatch: Colors.blue, useMaterial3: true),
      /*home: const ButtonPage(title: 'Componentes botones'),*/
      home: FormPage(),
    );
  }
}

class ButtonPage extends StatelessWidget {
  const ButtonPage({super.key, required this.title});

  final String title;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        floatingActionButton: FloatingActionButton(
            onPressed: () {
              sendMessage("Acción principal pulsada", context);
            },
            child: Icon(Icons.add)),
        appBar: AppBar(title: Text(title)),
        body: Padding(
            padding: const EdgeInsets.all(5.0),
            child: Center(
                child: Column(
              children: [
                Row(
                  crossAxisAlignment: CrossAxisAlignment.center,
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    buildNormalButton(context),
                    const Padding(
                        padding: EdgeInsets.only(left: 5.0, right: 5.0)),
                    buildIconButton(context)
                  ],
                ),
                Row(
                  children: [Expanded(child: buildSegmentedButtons())],
                ),
                Row(
                  children: [Expanded(child: SegmentedButtonComplete())],
                ),

              ],
            ))));
  }

  void sendMessage(String text, BuildContext context) {
    ScaffoldMessenger.of(context).showSnackBar(SnackBar(
      content: Text(text),
      duration: const Duration(seconds: 1),
    ));
  }

  Widget buildIconButton(context) {
    return Column(
      children: [
        IconButton(
          icon: const Icon(Icons.filter_drama),
          onPressed: () {
            sendMessage("Boton pulsado icono normal", context);
          },
        ),

        // Filled icon button
        IconButton.filled(
            onPressed: () {}, icon: const Icon(Icons.filter_drama)),

        // Filled tonal icon button
        IconButton.filledTonal(
            onPressed: () {}, icon: const Icon(Icons.filter_drama)),

        // Outlined icon button
        IconButton.outlined(
            onPressed: () {}, icon: const Icon(Icons.filter_drama)),
      ],
    );
  }

  Widget buildNormalButton(context) {
    return Column(
      children: [
        ElevatedButton(
            onPressed: () {
              print('Pulsado botón elevado');
            },
            onLongPress: () {
              sendMessage("Pulsación larga...", context);
            },
            child: Text("Elevated")),
        ElevatedButton.icon(
          onPressed: () {},
          label: const Text("Elevated icon"),
          icon: const Icon(Icons.add),
        ),
        FilledButton(onPressed: () {}, child: const Text("Filled")),
        OutlinedButton(onPressed: () {}, child: const Text("Outliner")),
        TextButton(onPressed: () {}, child: const Text("Text")),
      ],
    );
  }

  Widget buildSegmentedButtons() {
    return SegmentedButton(
        segments: <ButtonSegment<lenguage>>[
          ButtonSegment(value: lenguage.Dart, label: Text(lenguage.Dart.name)),
          ButtonSegment(value: lenguage.Java, label: Text(lenguage.Java.name)),
          ButtonSegment(
              value: lenguage.Kotlin, label: Text(lenguage.Kotlin.name)),
          ButtonSegment(value: lenguage.JavaScript, label: Text("Js"))
        ],
        selected: <lenguage>{
          lenguage.Dart
        },
        onSelectionChanged: (Set<lenguage> newSelection) {
          print(newSelection.first.name);
        });
  }
}

class SegmentedButtonComplete extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return _SegmentedButtonState();
  }
}

class _SegmentedButtonState extends State<SegmentedButtonComplete> {
  lenguage selected = lenguage.Dart;

  @override
  Widget build(BuildContext context) {
    return SegmentedButton(
        segments: <ButtonSegment<lenguage>>[
          ButtonSegment(value: lenguage.Dart, label: Text(lenguage.Dart.name)),
          ButtonSegment(value: lenguage.Java, label: Text(lenguage.Java.name)),
          ButtonSegment(
              value: lenguage.Kotlin, label: Text(lenguage.Kotlin.name)),
          ButtonSegment(value: lenguage.JavaScript, label: Text("Js"))
        ],
        selected: <lenguage>{
          selected
        },
        onSelectionChanged: (Set<lenguage> newSelection) {
          setState(() {
            selected = newSelection.first;
          });
        });
  }
}

enum payMethods { CredirCard, PayPal, Money, Wire }

final payMet = <String>[
  'Credit Card',
  'PayPal',
  'Money',
  'Wird Transfer'
]; // Creates growable list.

class RadioGroupComplete extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return _RadioGruopState();
  }
}

class _RadioGruopState extends State<RadioGroupComplete> {
  String? _selectedMethod = payMet[0];

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Row(children: <Widget>[
      ListTile(
        title: Text(payMet[0]),
        leading: Radio<String>(
          value: payMet[0],
          groupValue: _selectedMethod,
          onChanged: (String? value) {
            setState(() {
              _selectedMethod = value;
            });
          },
        ),
      ),
      ListTile(
        title: Text(payMet[1]),
        leading: Radio<String>(
          value: payMet[1],
          groupValue: _selectedMethod,
          onChanged: (String? value) {
            setState(() {
              _selectedMethod = value;
            });
          },
        ),
      )
    ]);
  }
}
