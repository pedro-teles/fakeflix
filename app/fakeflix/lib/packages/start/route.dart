import 'package:fakeflix/packages/start/presentation/start_screen.dart';
import 'package:flutter/material.dart';
import 'package:nuvigator/next.dart';

class StartRoute extends NuRoute {
  @override
  Widget build(BuildContext context, NuRouteSettings<Object> settings) =>
      const StartScreen();

  @override
  String get path => 'start';

  @override
  ScreenType get screenType => materialScreenType;

}
