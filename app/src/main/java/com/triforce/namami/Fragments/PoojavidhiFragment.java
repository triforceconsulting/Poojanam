package com.triforce.namami.Fragments;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.triforce.namami.PoojaInformation;
import com.triforce.namami.R;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PoojavidhiFragment extends Fragment {
    String puja;
    TextView txtTitleAarathi;
    TextView txtTitle;
    TextView txtDetail;
    private String downloadAudioPath;
    private String urlDownloadLink = "";
    TextView txtProgress;
    ImageView imgplay, imgpause;
    FrameLayout Frame_play;
    SeekBar SeekbartimeLine;
    private ProgressBar progressbar;
    ImageButton imgCancel;
    TextView timePos;
    DownloadFile downloadAudioFile;
    LinearLayout Lin_download;
    public  static MediaPlayer mPlayer;
    String url ;
    int pos = 0;
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "Namami";
    public static final String Voice = "Voice";
    public static final String FileExist = "FileExist";
    public static final String FileFrom = "FileFrom";
    String voice = "";
    String fileFrom = "";
    String fileExist = "";

    public PoojavidhiFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_poojavidhi, container, false);
        puja = PoojaInformation.puja;
        if((Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        SeekbartimeLine = (SeekBar) view.findViewById(R.id.seekbarPoojavidhi);
        Frame_play = (FrameLayout)view.findViewById(R.id.Lin_play);
        imgplay = (ImageView)view.findViewById(R.id.imgplay);
        imgCancel = (ImageButton)view.findViewById(R.id.imgcanceldown);
        Lin_download = (LinearLayout)view.findViewById(R.id.Lin_Download);
        txtTitleAarathi = (TextView)view.findViewById(R.id.txtTitleAarathi);
        imgpause = (ImageView)view.findViewById(R.id.imgpause);
        timePos = (TextView)view.findViewById(R.id.txtDur);
        txtProgress = (TextView)view.findViewById(R.id.txtProgress);
        progressbar = (ProgressBar)view.findViewById(R.id.progress_view);
        txtTitle = (TextView) view.findViewById(R.id.txtTitle_pujaVidhi);
        txtDetail = (TextView) view.findViewById(R.id.txtDetail_pujaVidhi);

        if(puja.equals("ganeshpuja")) {
            txtTitleAarathi.setText(R.string.str_Title_Audio_ganesh);
            txtTitle.setText(R.string.str_title_ganesh_pujavidhi);
            txtDetail.setText(R.string.str_detail_ganesh_pujavidhi);
            url = "https://firebasestorage.googleapis.com/v0/b/poojanam-d5278.appspot.com/o/audio%2Fmarathi%2Fpoojavidhi%2FparthivGanapathiPoojaVidhi.m4a?alt=media&token=bbe99028-32e5-4f1a-8e0d-af6fd30a6709";
        }
        else if(puja.equals("manglagauripuja")){
            txtTitleAarathi.setText(R.string.str_Title_Audio_maglagauri);
            txtTitle.setText(R.string.str_tiltle_mangla_pujavidhi);
            txtDetail.setText(R.string.str_detail_maglaguri_pujavidhi);
            url = "https://firebasestorage.googleapis.com/v0/b/poojanam-d5278.appspot.com/o/audio%2Fmarathi%2Fpoojavidhi%2FmangalagauriPoojaVidhi.m4a?alt=media&token=4bdea85d-9a90-4fb4-ab3d-63491c91e278";
        }
        else if(puja.equals("satyanarayanpuja")) {
            txtTitleAarathi.setText(R.string.str_Title_Audio_satyanarayan);
            txtTitle.setText(R.string.str_tiltle_satyanarayan_pujavidhi);
            txtDetail.setText(R.string.str_detail_satyanarayan_pujavidhi);
            url = "https://firebasestorage.googleapis.com/v0/b/poojanam-d5278.appspot.com/o/audio%2Fmarathi%2Fpoojavidhi%2FsatyanarayanPoojaVidhi.m4a?alt=media&token=2b90381b-9112-4d5f-9119-383f0d71db3e";
        }

        imgplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgplay.setVisibility(View.GONE);
                imgpause.setVisibility(View.VISIBLE);
                /*if (mPlayer != null) {
                    mPlayer.seekTo((int) (((double) pos / 100) * mPlayer.getDuration()));
                    mPlayer.start();
                }*/
                fileFrom = sharedpreferences.getString(FileFrom, "");
                voice = sharedpreferences.getString(Voice, "");
                downloadAudioPath = voice;
                    try {
                        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                        //mPlayer.setDataSource(downloadAudioPath);
                        Log.d("SetDatasource path", downloadAudioPath);

                        File filePath = new File(downloadAudioPath);

                        if (!filePath.exists()) {
                            filePath.createNewFile();
                        }

                        FileInputStream is = new FileInputStream(filePath);

                        if (mPlayer.isPlaying()) {
                            mPlayer.stop();
                        }
                        mPlayer.reset();

                        mPlayer.setDataSource(is.getFD());

                        mPlayer.prepare();

                        is.close();
                    } catch (IllegalArgumentException e) {
                        Toast.makeText(getActivity(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
                    } catch (SecurityException e) {
                        Toast.makeText(getActivity(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
                    } catch (IllegalStateException e) {
                        Toast.makeText(getActivity(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    mPlayer.seekTo((int) (((double) pos / 100) * mPlayer.getDuration()));

                    mPlayer.start();

            }
        });

        imgpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgplay.setVisibility(View.VISIBLE);
                imgpause.setVisibility(View.GONE);
                // TODO Auto-generated method stub
                if (mPlayer != null && mPlayer.isPlaying()) {
                    mPlayer.pause();
                    PoojaInformation.length = mPlayer.getCurrentPosition();
                }
            }
        });

        imgCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadAudioFile.cancel(true);
                Lin_download.setVisibility(View.GONE);
                Frame_play.setVisibility(View.VISIBLE);
                SeekbartimeLine.setVisibility(View.VISIBLE);
            }
        });

        SeekbartimeLine.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { //listener
            @Override
            public void onStopTrackingTouch(final SeekBar seekBar) {
                //add your event here
                mPlayer.seekTo((int) (((double) pos / 100) * mPlayer.getDuration()));
                PoojaInformation.length = mPlayer.getDuration();
            }

            @Override
            public void onStartTrackingTouch(final SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(final SeekBar seekBar, final int progress, final boolean fromUser) {
                pos = progress;
                SeekbartimeLine.setProgress(progress);
            }

        });

        return view;

    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("Resume Called");
        puja = PoojaInformation.puja;
        downloadAudioPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        File audioVoice = new File(downloadAudioPath + File.separator + "voices");
        if(!audioVoice.exists()){
            audioVoice.mkdir();
        }
        downloadAudioFile = new DownloadFile();
        mPlayer = new MediaPlayer();
        sharedpreferences = getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUserVisibleHint(false);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            // Load your data here or do network operations here
            System.out.println("Visible");
            try {
                if (mPlayer!=null && mPlayer.isPlaying()) {

                } else {
                    fileFrom = sharedpreferences.getString(FileFrom, "");
                    voice = sharedpreferences.getString(Voice, "");
                    fileExist = sharedpreferences.getString(FileExist, "");

                    if (fileExist.equals("true")) {
                        if (fileFrom.equals(puja)) {
                            Lin_download.setVisibility(View.GONE);
                            SeekbartimeLine.setVisibility(View.VISIBLE);
                            downloadAudioPath = voice;

                            try {
                                mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                                //mPlayer.setDataSource(downloadAudioPath);
                                Log.d("SetDatasource path", downloadAudioPath);

                                File filePath = new File(downloadAudioPath);

                                if (!filePath.exists())
                                {
                                    filePath.createNewFile();
                                }

                                FileInputStream is = new FileInputStream(filePath);

                                if(mPlayer.isPlaying())
                                {
                                    mPlayer.stop();
                                }
                                mPlayer.reset();

                                mPlayer.setDataSource(is.getFD());

                                mPlayer.prepare();

                                is.close();
                            } catch (IllegalArgumentException e) {
                                Toast.makeText(getActivity(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
                            } catch (SecurityException e) {
                                Toast.makeText(getActivity(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
                            } catch (IllegalStateException e) {
                                Toast.makeText(getActivity(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            if(PoojaInformation.length != 0) {
                                mPlayer.seekTo((int) (((double) PoojaInformation.length / 100) * mPlayer.getDuration()));
                            }

                            mPlayer.start();

                            ScheduledExecutorService myScheduledExecutorService = Executors.newScheduledThreadPool(1);

                            myScheduledExecutorService.scheduleWithFixedDelay(
                                    new Runnable() {
                                        @Override
                                        public void run() {
                                            monitorHandler.sendMessage(monitorHandler.obtainMessage());
                                        }
                                    },
                                    100, //initialDelay
                                    100, //delay
                                    TimeUnit.MILLISECONDS);

                        } else {

                            urlDownloadLink = url;
                            if (urlDownloadLink.equals("")) {
                                Toast.makeText(getActivity(), "Please add audio download link", Toast.LENGTH_LONG).show();
                            }
                            String filename = extractFilename();
                            downloadAudioPath = Environment.getExternalStorageDirectory().getAbsolutePath();
                            downloadAudioPath = downloadAudioPath + File.separator + "voices" + File.separator + filename;
                            downloadAudioFile.execute(urlDownloadLink, downloadAudioPath);
                        }
                    } else {
                        urlDownloadLink = url;
                        if (urlDownloadLink.equals("")) {
                            Toast.makeText(getActivity(), "Please add audio download link", Toast.LENGTH_LONG).show();
                        }
                        String filename = extractFilename();
                        downloadAudioPath = Environment.getExternalStorageDirectory().getAbsolutePath();
                        downloadAudioPath = downloadAudioPath + File.separator + "voices" + File.separator + filename;
                        downloadAudioFile.execute(urlDownloadLink, downloadAudioPath);
                    }
                }
                }catch(Exception e){
                    System.out.println("SharedPreference Error : " + e);
                }

        } else {
            System.out.println("Not Visible");
        }
    }

    Handler monitorHandler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            mediaPlayerMonitor();
        }

    };

    private void mediaPlayerMonitor(){
        if (mPlayer == null){
            SeekbartimeLine.setVisibility(View.INVISIBLE);
            Frame_play.setVisibility(View.INVISIBLE);
        }else{
            if(mPlayer.isPlaying()){
                SeekbartimeLine.setVisibility(View.VISIBLE);
                Frame_play.setVisibility(View.VISIBLE);
                imgplay.setVisibility(View.GONE);
                imgpause.setVisibility(View.VISIBLE);

                /*int mediaDuration = mPlayer.getDuration();
                int mediaPosition = mPlayer.getCurrentPosition();
                timeLine.setMax(mediaDuration);
                timeLine.setProgress(mediaPosition);
                //timePos.setText(String.valueOf((float)mediaPosition/1000) + "s");
                timeDur.setText((int) TimeUnit.MILLISECONDS.toMinutes(mediaPosition) + ":" + (TimeUnit.MILLISECONDS.toSeconds(mediaPosition/1000) ));*/


                long totalDuration = mPlayer.getDuration();
                long currentDuration = mPlayer.getCurrentPosition();

                // Displaying Total Duration time
                //timeDur.setText(""
                      //  + milliSecondsToTimer(totalDuration));
                // Displaying time completed playing
                timePos.setText(""
                        + milliSecondsToTimer(currentDuration));

                // Updating progress bar
                int progress = (getProgressPercentage(currentDuration,
                        totalDuration));
                // Log.d("Progress", ""+progress);
                SeekbartimeLine.setProgress(progress);


            } else {
                SeekbartimeLine.setVisibility(View.VISIBLE);
                Frame_play.setVisibility(View.VISIBLE);
            }
        }

    }

    public int getProgressPercentage(long currentDuration, long totalDuration){
        Double percentage = (double) 0;

        long currentSeconds = (int) (currentDuration / 1000);
        long totalSeconds = (int) (totalDuration / 1000);

        // calculating percentage
        percentage =(((double)currentSeconds)/totalSeconds)*100;

        // return percentage
        return percentage.intValue();
    }

    public String milliSecondsToTimer(long milliseconds){
        String finalTimerString = "";
        String secondsString = "";

        // Convert total duration into time
        int hours = (int)( milliseconds / (1000*60*60));
        int minutes = (int)(milliseconds % (1000*60*60)) / (1000*60);
        int seconds = (int) ((milliseconds % (1000*60*60)) % (1000*60) / 1000);
        // Add hours if there
        if(hours > 0){
            finalTimerString = hours + ":";
        }

        // Prepending 0 to seconds if it is one digit
        if(seconds < 10){
            secondsString = "0" + seconds;
        }else{
            secondsString = "" + seconds;}

        finalTimerString = finalTimerString + minutes + ":" + secondsString;

        // return timer string
        return finalTimerString;
    }



    private class DownloadFile extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... url) {
            Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
            int count;

            try {
                URL urls = new URL(url[0]);
                URLConnection connection = urls.openConnection();
                connection.connect();
                // this will be useful so that you can show a tipical 0-100% progress bar
                final int lenghtOfFile = connection.getContentLength();

                InputStream input = new BufferedInputStream(urls.openStream());
                OutputStream output = new FileOutputStream(url[1]);

                byte data[] = new byte[4096];

                long total = 0;

                while ((count = input.read(data)) != -1) {
                    total += count;
                    // publishing the progress....
                    publishProgress(" "+(int) (total * 100 / lenghtOfFile));
                    output.write(data, 0, count);
                }

                output.flush();
                output.close();
                input.close();

                /*final long finalTotal = total;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int percentage = ((int) (finalTotal * 100 / lenghtOfFile));
                        TextView tv = (TextView) findViewById(R.id.download_time);
                        tv.setText("" + percentage + "%");
                    }
                });*/


            } catch (Exception e) {
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... progress) {
            txtProgress.setText(progress[0] + "%");
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //progressbar.setVisibility(ProgressBar.VISIBLE);
            Lin_download.setVisibility(View.VISIBLE);
            SeekbartimeLine.setVisibility(View.GONE);
        }



        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //progressbar.setVisibility(ProgressBar.GONE);
            Lin_download.setVisibility(View.GONE);
            SeekbartimeLine.setVisibility(View.VISIBLE);
            try {
                File myDir = new File(voice);
                deleteRecursive(myDir);
                mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                //mPlayer.setDataSource(downloadAudioPath);
                Log.d("SetDatasource path", downloadAudioPath);

                File filePath = new File(downloadAudioPath);

                if (!filePath.exists())
                {
                    filePath.createNewFile();
                }

                FileInputStream is = new FileInputStream(filePath);

                if(mPlayer.isPlaying())
                {
                    mPlayer.stop();
                }
                mPlayer.reset();

                mPlayer.setDataSource(is.getFD());

                mPlayer.prepare();

                is.close();
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(Voice, downloadAudioPath);
                editor.putString(FileExist, "true");
                editor.putString(FileFrom, puja);
                editor.commit();
            } catch (IllegalArgumentException e) {
                Toast.makeText(getActivity(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
            } catch (SecurityException e) {
                Toast.makeText(getActivity(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
            } catch (IllegalStateException e) {
                Toast.makeText(getActivity(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
            /*try {
                mPlayer.prepare();
            } catch (IllegalStateException e) {
                Toast.makeText(getActivity(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                Toast.makeText(getActivity(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
            }*/
            mPlayer.start();

            ScheduledExecutorService myScheduledExecutorService = Executors.newScheduledThreadPool(1);

            myScheduledExecutorService.scheduleWithFixedDelay(
                    new Runnable() {
                        @Override
                        public void run() {
                            monitorHandler.sendMessage(monitorHandler.obtainMessage());
                        }
                    },
                    100, //initialDelay
                    100, //delay
                    TimeUnit.MILLISECONDS);

        }
    }

    private String extractFilename() {
        if (urlDownloadLink.equals("")) {
            return "";
        }
        String newFilename = "";
        if (urlDownloadLink.contains("/")) {
            int dotPosition = urlDownloadLink.lastIndexOf("/");
            newFilename = urlDownloadLink.substring(dotPosition + 1, urlDownloadLink.length());
        } else {
            newFilename = urlDownloadLink;
        }
        return newFilename;
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("Stop Called");
        if(mPlayer!=null && mPlayer.isPlaying())
        {
            mPlayer.stop();
            mPlayer.release();
            mPlayer = null;
        }
        downloadAudioFile.cancel(true);
        PoojaInformation.length = 0;
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("Pause Called");
        imgplay.setVisibility(View.VISIBLE);
        imgpause.setVisibility(View.GONE);
        downloadAudioFile.cancel(true);
        // TODO Auto-generated method stub
        if (mPlayer != null && mPlayer.isPlaying()) {
            mPlayer.pause();
            PoojaInformation.length = mPlayer.getCurrentPosition();
        }
    }

    public void deleteRecursive(File fileOrDirectory) {

        if (fileOrDirectory.isDirectory()) {
            for (File child : fileOrDirectory.listFiles()) {
                deleteRecursive(child);
            }
        }

        fileOrDirectory.delete();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("Destroy Called");
        if(mPlayer!=null && mPlayer.isPlaying())
        {
            mPlayer.stop();
            mPlayer.release();
            mPlayer = null;
        }
        downloadAudioFile.cancel(true);
        PoojaInformation.length = 0;
    }

}
