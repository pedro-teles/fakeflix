import 'package:fakeflix/router/fakeflix_router.dart';
import 'package:flutter/material.dart';
import 'package:nuvigator/next.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Fakeflix',
      theme: ThemeData.dark().copyWith(scaffoldBackgroundColor: Colors.black),
      home: Nuvigator(
        router: FakeflixRouter(),
      )
    );
  }
}
