package com.java.proxy;

import java.util.ArrayList;

interface YTDownload{
    void downloadVideo(int id);
}

class RealYouTubeDownloader implements YTDownload {

    @Override
    public void downloadVideo(int id) {
        System.out.println("Start downloading video with id: " + id);
    }
}

class ProxyYouTubeDownloader implements YTDownload {

    private RealYouTubeDownloader realDownloader;
    private ArrayList<Integer> downloadVideos;
    public ProxyYouTubeDownloader() {
        realDownloader = new RealYouTubeDownloader();
        downloadVideos = new ArrayList<>();
    }
    @Override
    public void downloadVideo(int id) {
        if (!downloadVideos.contains(id)){
            this.downloadVideos.add(id);
            this.realDownloader.downloadVideo(id);
        }
    }
}

public class ProxyMain {
    public static void main(String[] args) {
        ProxyYouTubeDownloader proxy = new ProxyYouTubeDownloader();

        proxy.downloadVideo(1);
        proxy.downloadVideo(1);
        proxy.downloadVideo(2);
        proxy.downloadVideo(3);
        proxy.downloadVideo(3);
        proxy.downloadVideo(4);
    }
}
