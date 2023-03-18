import 'package:fakeflix/common/sdui/model/screen_data.dart';

abstract class SplashState {}

class Loading extends SplashState {}

class Loaded extends SplashState {
  Loaded(this.screenWidgets);

  final ScreenWidgets screenWidgets;
}

class Error extends SplashState {}
