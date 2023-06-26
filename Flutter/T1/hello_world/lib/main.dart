import 'package:flutter/material.dart';
import 'package:hello_world/HomePage.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    //TODO: implement build
    return MaterialApp(
      title: "Hello World",
      theme: ThemeData(primaryColor: Colors.blueGrey),
      home: HomePage(title: "Primera app"),
    );
  }
}
