import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:fakeflix/packages/splash/bloc/state/splash_state.dart';
import 'package:fakeflix/packages/splash/bloc/event/SplashEvent.dart';

class SplashBloc extends Bloc<SplashEvent, SplashState> {
  SplashBloc() : super(Loading()) {
    on<Load>((event, emit) async {
      await Future.delayed(const Duration(seconds: 1));
      emit(Loaded());
    });
  }

}
