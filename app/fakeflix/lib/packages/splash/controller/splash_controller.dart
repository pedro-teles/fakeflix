import 'package:fakeflix/packages/splash/bloc/event/SplashEvent.dart';
import 'package:fakeflix/packages/splash/bloc/splash_bloc.dart';
import 'package:fakeflix/packages/splash/bloc/state/splash_state.dart';
import 'package:fakeflix/packages/splash/presentation/SplashScreen.dart';
import 'package:fakeflix/packages/welcome/presentation/welcome_screen.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

class SplashController extends StatelessWidget {
  SplashController({Key? key}) : super(key: key);

  final bloc = SplashBloc();

  @override
  Widget build(BuildContext context) {
    return BlocBuilder<SplashBloc, SplashState>(
      bloc: bloc,
      builder: (context, state) {
        switch(state.runtimeType) {
          case Loading:
            bloc.add(Load());

            return const SplashScreen();
          case Loaded:
            return const WelcomeScreen();
          case Error:
            return const Text('Error');
        }

        return Container();
      },
    );
  }

}
