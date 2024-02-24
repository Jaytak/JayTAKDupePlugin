# JayTAK Dupe Plugin

Simple plugin to dupe items.<br>
I needed a plugin for my own server to dupe items as an admin tool, so i wrote one and decided to put it on GitHub.

>[!NOTE]
> As a full time student, i am unable to provide support for this plugin. I am only sharing this to GitHub incase someone else out there finds it useful.<br>
>Feel free to submit bugs and feature requests, but there is zero guarntee i ever get around to fixing/implementing them.

#### Commands
`/jd /dupe /jdupe`

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
> This plugin has only been tested on Paper builds 407, 409, 422, 423, 434<br>
> I am unable to  garuntee this  plugin will work on any other minecraft server builds.

> [!CAUTION]
> This is obvious, but be very careful who you give the permission node to.