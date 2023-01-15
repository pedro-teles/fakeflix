import 'package:fakeflix/design/design.dart';
import 'package:flutter/material.dart';
import 'package:nuvigator/next.dart';

class StartScreen extends StatelessWidget {
  const StartScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Screen(
      backgroundColor: Colors.white,
      body: Padding(
        padding: const EdgeInsets.all(28.0),
        child: Column(
          children: [
            Align(
              alignment: Alignment.centerRight,
              child: GestureDetector(
                onTap: () => Nuvigator.of(context).pop(),
                child: const Icon(
                  Icons.close,
                  color: Colors.grey,
                ),
              ),
            ),
            const SizedBox(
              height: 24.0,
            ),
            const CalloutMessage(
              title: 'Tudo pronto para assistir?',
              description: 'Informe seu email para criar ou acessar sua conta.',
            ),
            const SizedBox(
              height: 16.0,
            ),
            const EmailTextField(),
            const SizedBox(
              height: 16.0,
            ),
            const Button(label: 'VAMOS LÁ')
          ],
        ),
      ),
    );
  }
}

class CalloutMessage extends StatelessWidget {
  const CalloutMessage({Key? key, required this.title, this.description})
      : super(key: key);

  final String title;
  final String? description;

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.end,
      children: [
        Text(
          title,
          style: const TextStyle(
              fontSize: 28.0, fontWeight: FontWeight.bold, color: Colors.black),
          textAlign: TextAlign.center,
        ),
        const SizedBox(
          height: 16.0,
        ),
        Visibility(
          visible: description != null,
          child: Text(
            description!,
            style: const TextStyle(color: Colors.black),
            textAlign: TextAlign.center,
          ),
        ),
        const SizedBox(
          height: 16.0,
        )
      ],
    );
  }
}
