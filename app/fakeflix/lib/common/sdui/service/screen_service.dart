import 'dart:convert';

import 'package:fakeflix/common/connector/connector.dart';
import 'package:fakeflix/common/sdui/mapper/screen_mapper.dart';
import 'package:fakeflix/common/sdui/model/screen_data.dart';

import 'package:http/http.dart';

class ScreenService extends Connector {
  Future<ScreenWidgets> getUiComponents(String url) async {
    final uri = Uri.http(baseUrl, url);
    final Response response = await httpClient.get(uri);
    final decodedResponse = jsonDecode(utf8.decode(response.bodyBytes)) as Map<String, dynamic>;

    return ScreenMapper.toScreenWidgets(decodedResponse);
  }
}
