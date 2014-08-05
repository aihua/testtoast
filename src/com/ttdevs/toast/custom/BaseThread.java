package com.ttdevs.toast.custom;

import android.os.Process;

/**
 * �����࣬���̵߳ļ򵥷�װ
 * 
 * @author ttdevs
 */
public abstract class BaseThread extends Thread {

	private volatile boolean mQuit = false;

	public BaseThread() {

	}

	/**
	 * prepare if needed
	 */
	public boolean prepare() {

		return true;
	}

	/**
	 * run body
	 */
	public abstract void execute();

	/**
	 * recycle if needed
	 */
	public void recycle() {

	}

	/**
	 * stop thread
	 */
	public final void quit() {
		mQuit = true;
		interrupt();
	}

	@Override
	public void run() {
		// TODO
		Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
		if (!prepare()) {
			return;
		}
		while (true) {
			if (mQuit) {  
                recycle();  
                return;  
            } 
			try {
				execute();
			} catch (Exception e) {// } catch (InterruptedException e) {}
				if (mQuit) {
					recycle();
					return;
				}
				continue;
			}
		}
	}
}