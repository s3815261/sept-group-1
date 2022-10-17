import 'package:flutter/material.dart';
import 'package:hexcolor/hexcolor.dart';

class ThemeConstants {
  final Color _primaryColor = HexColor('#DC54FE');
  final Color _secondaryColor = HexColor('#6C07EE');
  final Color _accentColor = HexColor('#8A02AE');
  final Color _errorColor = Colors.red;

  get primaryColor => _primaryColor;
  get secondaryColor => _secondaryColor;
  get accentColor => _accentColor;
  get errorColor => _errorColor;
}