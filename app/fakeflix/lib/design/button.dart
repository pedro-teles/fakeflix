import 'package:flutter/material.dart';
import 'package:nuvigator/next.dart';

class Button extends StatelessWidget {
  const Button({Key? key, required this.label, this.deeplink, this.onPressed}) : super(key: key);

  final String label;
  final String? deeplink;
  final Function? onPressed;

  @override
  Widget build(BuildContext context) {
    return ElevatedButton(
      onPressed: () {
        if (deeplink != null) {
          Nuvigator.of(context).open(deeplink);
        } else if (onPressed != null) {
          onPressed!();
        }
      },
      style: ElevatedButton.styleFrom(
          primary: const Color(0xffb81d24),
          minimumSize: const Size.fromHeight(50)),
      child: Text(label),
    );
  }
}
