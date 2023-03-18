import 'package:flutter/material.dart';

class Screen extends StatelessWidget {
  const Screen({Key? key, this.body, this.backgroundColor}) : super(key: key);

  final Widget? body;
  final Color? backgroundColor;

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(8.0),
      child: Scaffold(
        backgroundColor: backgroundColor ?? Colors.black,
        body: body,
      ),
    );
  }
}
