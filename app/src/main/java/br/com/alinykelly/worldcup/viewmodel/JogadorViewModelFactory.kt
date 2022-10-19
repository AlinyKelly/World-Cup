package br.com.alinykelly.worldcup.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class JogadorViewModelFactory : ViewModelProvider.Factory {
    
    override fun  <T: ViewModel?> create(modelClass: Class<T>): T {
        return JogadorViewModel() as T
    }
}

