import 'package:flutter/material.dart';

class SplashScreen extends StatelessWidget {
  const SplashScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Center(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Image.asset('images/fakeflix_logo.png'),
          const CircularProgressIndicator(
            color: Color(0xffb81d24),
          )
        ],
      ),
    );
  }
}
