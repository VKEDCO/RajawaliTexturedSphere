package org.vkedco.mobappdev.ar.rajawalitexturedsphere;

import javax.microedition.khronos.opengles.GL10;

import org.vkedco.mobappdev.ar.rajawalitutorial_01.R;

import rajawali.Object3D;
import rajawali.lights.DirectionalLight;
import rajawali.materials.Material;
import rajawali.materials.textures.ATexture.TextureException;
import rajawali.materials.textures.Texture;
import rajawali.primitives.Sphere;
import android.content.Context;
import rajawali.Camera;

enum ROTATION { VERTICAL, HORIZONTAL }

public class RajawaliSphere_Renderer extends rajawali.renderer.RajawaliRenderer {
	
	DirectionalLight mLight;
	Object3D mSphere;
	Context mContext = null;
	Camera mCamera = null;
	ROTATION mRot = ROTATION.VERTICAL;
	int mRotSpeed = 1; 
	
	private final void setRotHorizontal() {
		mRot = ROTATION.HORIZONTAL;
	}
	
	private final void setRotVertical() {
		mRot = ROTATION.VERTICAL;
	}

	public RajawaliSphere_Renderer(Context context) {
		super(context);
		mContext = context;
		setFrameRate(60);
	}
	
	public void initScene() {
		// x, y, z
		mLight = new DirectionalLight(1f, 0.2f, -1.0f);
		mLight.setColor(1.0f, 1.0f, 1.0f);
		mLight.setPower(2);
		
		try {
			Material material = new Material();
			// You can mountain different textures from /res/drawable/
			// material.addTexture(new Texture("earthColors", R.drawable.earthtruecolor_nasa_big));
			setRotHorizontal();
			material.addTexture(new Texture("bhagavatgita", R.drawable.bhagavatgita_v1_large));
			material.setColorInfluence(0);
			mSphere = new Sphere(1, 20, 20);
			mSphere.setMaterial(material);
			getCurrentScene().addLight(mLight);
			super.addChild(mSphere);
		} catch (TextureException e) {
			e.printStackTrace();
		}
		
		getCurrentCamera().setZ(4.2f);
	}
	
	@Override
	public void onDrawFrame(GL10 glUnused) {
		super.onDrawFrame(glUnused);
		switch ( mRot ) {
		case HORIZONTAL: rotateHorizontally(mRotSpeed); break;
		case VERTICAL: rotateVertically(mRotSpeed); break;
		}
		
		//mSphere.setRotX(mSphere.getRotX() + 1); // vertical rotation
		//mSphere.setRotY(mSphere.getRotY() + 1); // horizontal rotation
	}
	
	private final void rotateVertically(int speed) {
		mSphere.setRotX(mSphere.getRotX() + speed);
	}
	
	private final void rotateHorizontally(int speed) {
		mSphere.setRotY(mSphere.getRotY() + speed);
	}
	
	
	
	
	

}
