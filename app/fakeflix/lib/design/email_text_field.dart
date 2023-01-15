import 'package:flutter/material.dart';

class EmailTextField extends StatelessWidget {
  const EmailTextField({Key? key,}) : super(key: key);

  final _outlineBorder = const OutlineInputBorder();

  @override
  Widget build(BuildContext context) {
    return TextField(
      style:
      const TextStyle(color: Colors.black, decorationColor: Colors.black),
      decoration: InputDecoration(
        labelText: 'Email',
        labelStyle: const TextStyle(color: Colors.black),
        enabledBorder: _outlineBorder,
        border: _outlineBorder,
      ),
    );
  }
}
