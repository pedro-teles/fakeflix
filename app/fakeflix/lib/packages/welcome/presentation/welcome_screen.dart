import 'package:fakeflix/common/sdui/mapper/screen_mapper.dart';
import 'package:fakeflix/common/sdui/model/screen_data.dart';
import 'package:flutter/widgets.dart' hide Page;

class WelcomeScreen extends StatelessWidget {
  const WelcomeScreen(this.screenWidgets, {Key? key}) : super(key: key);

  final ScreenWidgets screenWidgets;

  @override
  Widget build(BuildContext context) {
    return ScreenMapper.renderScreen(screenWidgets);
  }
}
