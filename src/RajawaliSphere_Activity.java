package org.vkedco.mobappdev.ar.rajawalitexturedsphere;

import rajawali.RajawaliActivity;
import android.os.Bundle;


public class RajawaliSphere_Activity extends RajawaliActivity {
	
	private RajawaliSphere_Renderer mRenderer;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.mRenderer = new RajawaliSphere_Renderer(this);
		this.mRenderer.setSurfaceView(mSurfaceView);
		super.setRenderer(mRenderer);
	}
}
