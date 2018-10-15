package com.hedera.file;

import java.security.spec.InvalidKeySpecException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.hedera.account.*;
import com.hedera.sdk.account.HederaAccount;
import com.hedera.sdk.common.HederaDuration;
import com.hedera.sdk.common.HederaKey.KeyType;
import com.hedera.sdk.cryptography.HederaCryptoKeyPair;
import com.hedera.sdk.file.HederaFile;
import com.hedera.utilities.*;
import com.hedera.sdk.common.HederaTransactionAndQueryDefaults;

public final class DemoFile {
	final static Logger logger = LoggerFactory.getLogger(DemoFile.class);
	
	public static void main (String... arguments) throws Exception {

		boolean doCreate = false;
		boolean doGetInfo = false;
		boolean doAppend = false;
		boolean doUpdate = false;
		boolean doGetContents = false;
		boolean doDelete = false;
		
		// setup a set of defaults for query and transactions
		HederaTransactionAndQueryDefaults txQueryDefaults = new HederaTransactionAndQueryDefaults();
		txQueryDefaults = ExampleUtilities.getTxQueryDefaults();

    	HederaAccount account = new HederaAccount();
    	// setup transaction/query defaults (durations, etc...)
    	txQueryDefaults.generateRecord = true;
    	account.txQueryDefaults = txQueryDefaults;
    	account.autoRenewPeriod = new HederaDuration(31536000, 0);

    	HederaCryptoKeyPair newAccountKey = new HederaCryptoKeyPair(KeyType.ED25519);
    	
    	account = AccountCreate.create(account, newAccountKey, 1000);

        // the paying account is now the new account
        txQueryDefaults.payingAccountID = account.getHederaAccountID();
        txQueryDefaults.payingKeyPair = newAccountKey;
        txQueryDefaults.memo = "File Tests";
		
    	// new file object
    	HederaFile file = new HederaFile();
    	// setup transaction/query defaults (durations, etc...)
    	txQueryDefaults.fileWacl = new HederaCryptoKeyPair(KeyType.ED25519);
    	file.txQueryDefaults = txQueryDefaults;

    	doCreate = true; //OK
		doGetInfo = true; //OK
		doGetContents = true; //OK
		doAppend = true; //OK
		doUpdate = true; //OK
		doDelete = true; //OK
		
		// create a file
		if (doCreate) {
			String fileContents = "-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789" + 
					"-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789-0123456789";
			file = FileCreate.create(file, fileContents.getBytes());
		}
        if (file != null) {
        	if (doGetInfo) {
        		FileGetInfo.getInfo(file);
        	}
        	if (doAppend) {
	    		// append to a file
	            FileAppend.append(file,"Appended contents".getBytes());
	    		// get file contents
	        	if (doGetContents) {
	        		FileGetContents.getContents(file);
	        	}
        	}
        	if (doUpdate) {
        		file = FileUpdate.update(file, 10, 2, "Updated contents".getBytes());
	    		// get file contents
	        	if (doGetContents) {
	        		FileGetContents.getContents(file);
	        	}
        	}
    		// get file contents
        	if (doGetContents) {
        		FileGetContents.getContents(file);
        	}
    		// get file info
        	if (doGetInfo) {
        		FileGetInfo.getInfo(file);
        	}
    		// delete the file
        	if (doDelete) {
        		FileDelete.delete(file);
        	}
        }
	}

}