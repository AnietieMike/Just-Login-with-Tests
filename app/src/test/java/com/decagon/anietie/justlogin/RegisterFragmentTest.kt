package com.decagon.anietie.justlogin

import org.junit.Assert.*
import android.content.Context
import com.decagon.anietie.justlogin.Validator.verifyPhoneNum
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

class RegisterFragmentTest {

    @Test
    fun verifyPhoneNum_startsWithZeroEight_returnsTrue() {
        //  Given
        val phone = "08104690512"
        //  When
        val result = verifyPhoneNum(phone)
        //  Then
        assertTrue(result)
    }

    @Test
    fun verifyPhoneNum_startsWithZeroNine_returnsTrue() {
        //  Arrange
        val phone = "09087229018"
        //  Act
        val result = verifyPhoneNum(phone)
        //  Assert
        assertTrue(result)
    }

    @Test
    fun verifyPhoneNum_lessThanElevenDigits_returnsFalse() {
        // Given
        val phone = "0810234345"
        // When
        val result = verifyPhoneNum(phone)
        // Then
        assertFalse(result)
    }

    @Test
    fun verifyPhoneNum_startsWithZeroAndMoreThanEleven_returnsFalse() {
        // Given
        val phone = "081046905122"
        // When
        val result = verifyPhoneNum(phone)
        // Then
        assertFalse(result)
    }

    @Test
    fun verifyPhone_startsWithTwoAndMoreThanThirteen_returnsFalse() {
        // Given
        val phone = "23481046905123"
        // When
        val result = verifyPhoneNum(phone)
        // Then
        assertFalse(result)
    }
}