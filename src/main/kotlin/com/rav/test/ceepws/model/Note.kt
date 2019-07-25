package com.rav.test.ceepws.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
data class Note(@Id
           @GeneratedValue
           @JsonProperty(value= "id", access = JsonProperty.Access.READ_ONLY)
           val id: Long = 0L,
           val title: String = "",
           val description: String = ""){
}