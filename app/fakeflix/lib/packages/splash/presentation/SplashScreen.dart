import 'package:flutter/material.dart';
import 'package:fakeflix/design/design.dart';

class SplashScreen extends StatelessWidget {
  const SplashScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Screen(
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Image.asset('images/fakeflix_logo.png'),
            const CircularProgressIndicator(
              color: Color(0xffb81d24),
            )
          ],
        ),
      ),
    );
  }
}
