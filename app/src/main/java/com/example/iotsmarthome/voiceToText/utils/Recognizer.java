package com.example.iotsmarthome.voiceToText.utils;


import com.sun.jna.PointerType;

public class Recognizer extends PointerType implements AutoCloseable {

    public Recognizer(Model model, float sampleRate) {
        super(LibVosk.vosk_recognizer_new(model, sampleRate));
    }

    public boolean acceptWaveForm(short[] data, int len) {
        return LibVosk.vosk_recognizer_accept_waveform_s(this.getPointer(), data, len);
    }

    public String getResult() {
        return LibVosk.vosk_recognizer_result(this.getPointer());
    }

    public String getPartialResult() {
        return LibVosk.vosk_recognizer_partial_result(this.getPointer());
    }

    public String getFinalResult() {
        return LibVosk.vosk_recognizer_final_result(this.getPointer());
    }

    public void reset() {
        LibVosk.vosk_recognizer_reset(this.getPointer());
    }

    @Override
    public void close() {
        LibVosk.vosk_recognizer_free(this.getPointer());
    }
}
