# JayTAK Dupe Plugin

<img src="https://cdn.modrinth.com/data/6GmjexmT/763a3a8415fa91d680f8d2fee47a58d0210ff097.png" width="150">

Version 1.0.1 (for paper 1.20.4)

Simple plugin to dupe items.<br>
I needed a plugin for my own server to dupe items as an admin tool, so I wrote one.

Download from [Modrinth](https://modrinth.com/plugin/jaytak-dupe)

>[!NOTE]
> As a full-time student, I cannot provide support for this plugin. I am only sharing this to GitHub in case someone else out there finds it useful. I will do my best to keep it up to date with the latest paper builds where possible.<br>
>Feel free to submit bugs and feature requests, but there is no guarantee I ever get around to fixing/implementing them.

#### Commands & Aliases:
```
/jaytakdupe
/jdupe
/dupe
/jd
```

#### Optional arguments:
`+ - / * x X`

> [!TIP]
> Plus and minus operations can be done in one argument, multiply and divide require a space.

##### Example Usage
```
/jd
/jd * 3
/jd + 10
/jd +10
/jd - 20
/jd -20
/jd / 2
/jd x 4
/jd X 4
```

##### Permission Node
`jaytakdupeplugin.dupe`

> [!IMPORTANT]
> This plugin will prevent unsafe usage.<br>
> If the calculated stack size exceeds 64 it will be capped at 64, values above this can lead to unstable behaviour and often leads to item loss.<br>
> If the calculated stack size is below 1 it will be clipped to 1 to prevent item loss.

> [!WARNING]
> This plugin has only been tested on 1.20.4 Paper builds 407, 409, 422, 423, 434<br>
> I am unable to guarantee this plugin will work on any other Minecraft server builds.

> [!CAUTION]
> This is obvious, but be very careful who you give the permission node.


### bStats

![Plugin bStats](https://bstats.org/signatures/bukkit/JayTAK%20Dupe%20Plugin.svg)
