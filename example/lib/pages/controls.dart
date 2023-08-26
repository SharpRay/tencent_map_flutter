import 'dart:io';

import 'package:flutter/material.dart';
import 'package:tencent_map/tencent_map.dart';

import '../utils.dart';

class ControlsPage extends StatefulWidget {
  const ControlsPage({Key? key}) : super(key: key);

  @override
  createState() => _State();
}

const scaleControls = '比例尺';
const compass = '指南针';
const myLocationButtonEnabled = '定位按钮';

class _State extends State<ControlsPage> {
  final _items = [scaleControls, compass, myLocationButtonEnabled];
  final _state = {
    scaleControls: true,
    compass: true,
    myLocationButtonEnabled: !Platform.isIOS,
  };

  @override
  build(context) {
    final items = _items.map(
      (item) => Column(
        mainAxisSize: MainAxisSize.min,
        children: [
          Padding(padding: const EdgeInsets.only(top: 16), child: Text(item)),
          Switch(
            value: _state[item]!,
            onChanged: item == myLocationButtonEnabled && Platform.isIOS
                ? null
                : (value) => setState(() => _state[item] = value),
          ),
        ],
      ),
    );
    return Scaffold(
      appBar: AppBar(title: const Text('控件：比例尺、指南针、定位按钮')),
      body: TencentMap(
        androidTexture: true,
        mapType: context.isDark ? MapType.dark : MapType.normal,
        scaleControlsEnabled: _state[scaleControls]!,
        compassEnabled: _state[compass]!,
        myLocationButtonEnabled: _state[myLocationButtonEnabled]!,
      ),
      bottomNavigationBar: Row(
        mainAxisAlignment: MainAxisAlignment.spaceAround,
        children: items.toList(),
      ),
    );
  }
}
