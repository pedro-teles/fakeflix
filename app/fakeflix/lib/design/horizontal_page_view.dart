import 'package:fakeflix/design/design.dart';
import 'package:flutter/material.dart' hide Page;

class HorizontalPageView extends StatelessWidget {
  const HorizontalPageView({Key? key, required this.pages}) : super(key: key);

  final List<Page> pages;

  @override
  Widget build(BuildContext context) {
    return Flexible(
      child: PageView(
        controller: PageController(),
        children: pages,
      ),
    );
  }
}
