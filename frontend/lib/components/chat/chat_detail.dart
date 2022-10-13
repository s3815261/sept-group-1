import 'package:flutter/material.dart';

class ChatDetailPageAppBar extends StatelessWidget implements PreferredSizeWidget{
  const ChatDetailPageAppBar({super.key});

  @override
  Widget build(BuildContext context) {
    return AppBar(
      elevation: 0,
      automaticallyImplyLeading: false,
      backgroundColor: Colors.white,
      flexibleSpace: SafeArea(
        child: Container(
          padding: const EdgeInsets.only(right: 16),
          child: Row(
            children: [
              IconButton(
                onPressed: (){
                  Navigator.pop(context);
                },
                icon: const Icon(Icons.arrow_back_ios,color: Colors.black,),
              ),
              const SizedBox(width: 2,),
              const CircleAvatar(
                backgroundImage: AssetImage("images/userImage1.jpeg"),
                maxRadius: 20,
              ),
              const SizedBox(width: 12,),
              Expanded(
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: const [
                    Text("Jane Russel",style: TextStyle(fontWeight: FontWeight.w600),),
                    SizedBox(height: 6,),
                    // Text("Online",style: TextStyle(color: Colors.green,fontSize: 12),),
                  ],
                ),
              ),
              Icon(Icons.more_vert,color: Colors.grey.shade700,),
            ],
          ),
        ),
      ),
    );
  }

  @override
  // TODO: implement preferredSize
  Size get preferredSize => const Size.fromHeight(kToolbarHeight);
}