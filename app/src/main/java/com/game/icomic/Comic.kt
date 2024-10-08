package com.game.icomic

import java.io.Serializable

data class Comic(val title: String, val pages: List<String>) : Serializable
