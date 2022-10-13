import 'package:flutter/material.dart';

class IconRounded extends StatelessWidget {
  final IconData icon;
  final double margin;
  final double padding;
  final Color shade;
  final double size;

  const IconRounded({super.key, required this.icon, this.margin = 16, this.padding = 16, this.shade = const Color(0xFFE0E0E0), this.size = 32});

  @override
  build(BuildContext context) {
    return Container(
      margin: EdgeInsets.all(margin),
      padding: EdgeInsets.all(padding),
      decoration: BoxDecoration(
          borderRadius: BorderRadius.circular(10), color: shade),
      child: Icon(
        icon,
        size: size,
      ),
    );
  }
}
