import 'package:fakeflix/common/sdui/model/screen_data.dart';
import 'package:fakeflix/design/design.dart';
import 'package:flutter/material.dart' hide Page;

const String BUTTON = 'BUTTON';
const String PAGE_VIEW = 'PAGE_VIEW';

class ScreenMapper {
  static ScreenWidgets toScreenWidgets(Map<String, dynamic> response) {
    final screen = response['screen'] as Map<String, dynamic>;
    final body = screen['body'] as List<dynamic>;

    return ScreenWidgets(
      ScreenComponent(
        toServerDrivenWidget(
          body,
        ),
      ),
    );
  }

  static List<ServerDrivenWidget> toServerDrivenWidget(List<dynamic> body) {
    return List<ServerDrivenWidget>.from(
      body.map((widget) {
        switch (widget['type']) {
          case BUTTON:
            return ButtonComponent(
              widget['label'],
              widget['deeplink'],
            );
          case PAGE_VIEW:
            return PageViewComponent(
              List<PageComponent>.from(
                widget['pages'].map(
                  (page) => PageComponent(
                    page['title'],
                    page['description'],
                  ),
                ),
              ),
            );
        }
      }),
    );
  }

  static Screen renderScreen(ScreenWidgets screenWidgets) {
    return Screen(
      body: Column(
        mainAxisAlignment: MainAxisAlignment.start,
        children: [
          ...screenWidgets.screen.body.map((component) {
            if (component is PageViewComponent) {
              return HorizontalPageView(
                pages: component.pages
                    .map(
                      (page) => Page(
                    title: page.title,
                    description: page.description,
                  ),
                )
                    .toList(),
              );
            } else if (component is ButtonComponent) {
              return Button(
                label: component.label,
                deeplink: component.deeplink,
              );
            }

            return const SizedBox();
          })
        ],
      ),
    );
  }
}
