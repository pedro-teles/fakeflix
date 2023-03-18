import 'package:flutter/material.dart';

class Page extends StatelessWidget {
  const Page({Key? key, required this.title, required this.description})
      : super(key: key);

  final String title;
  final String description;

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.only(left: 48.0, right: 48.0, bottom: 64.0),
      child: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.end,
          children: [
            Text(
              title,
              style:
              const TextStyle(fontSize: 32.0, fontWeight: FontWeight.bold),
              textAlign: TextAlign.center,
            ),
            const SizedBox(
              height: 16.0,
            ),
            Text(
              description,
              textAlign: TextAlign.center,
            )
          ],
        ),
      ),
    );
  }
}
