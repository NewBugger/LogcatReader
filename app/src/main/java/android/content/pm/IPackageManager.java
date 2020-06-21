package android.content.pm;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;


public interface IPackageManager extends IInterface {

    // https://cs.android.com/android/platform/superproject/+/
    // master:out/soong/.intermediates/frameworks/base/framework-minus-apex/
    // android_common/xref28/srcjars.xref/frameworks/base/core/
    // java/android/content/pm/IPackageManager.java;bpv=1;bpt=1;l=...

    // l=5500
    void grantRuntimePermission(String packageName, String permissionName, int userId)
            throws RemoteException;

    // l=5521
    void revokeRuntimePermission(String packageName, String permissionName, int userId)
            throws RemoteException;

    abstract class Stub extends Binder implements IPackageManager {
        public static IPackageManager asInterface(IBinder obj) {
            throw new UnsupportedOperationException();
        }
    }

}
