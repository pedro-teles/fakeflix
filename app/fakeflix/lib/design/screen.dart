import 'package:flutter/material.dart';

class Screen extends StatelessWidget {
  const Screen({Key? key, this.body}) : super(key: key);

  final Widget? body;

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(8.0),
      child: Scaffold(
        body: body,
      ),
    );
  }
}
