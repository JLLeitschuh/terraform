package com.urbancode.terraform.tasks.rackspace;

import org.apache.log4j.Logger;

import com.urbancode.terraform.credentials.common.Credentials;
import com.urbancode.terraform.credentials.common.CredentialsException;
import com.urbancode.terraform.credentials.rackspace.CredentialsRackspace;
import com.urbancode.terraform.tasks.common.EnvironmentTask;
import com.urbancode.terraform.tasks.common.TerraformContext;
import com.urbancode.x2o.tasks.CreationException;
import com.urbancode.x2o.tasks.DestructionException;
import com.urbancode.x2o.tasks.RestorationException;

public class ContextRackspace extends TerraformContext {
    //**********************************************************************************************
    // CLASS
    //**********************************************************************************************
    static private final Logger log = Logger.getLogger(ContextRackspace.class);

    //**********************************************************************************************
    // INSTANCE
    //**********************************************************************************************
    private EnvironmentTaskRackspace env;
    private CredentialsRackspace creds;
    protected RackspaceRestClient client;

    //----------------------------------------------------------------------------------------------
    @Override
    public void create() throws CreationException {
        client = new RackspaceRestClient();
        try {
            client.authenticate(creds.getUser(), creds.getApiKey());
            env.create();
        } catch (AuthenticationException e) {
            log.error("Authentication failed. Cannot create environment.");
            throw new CreationException(e);
        }

    }

    //----------------------------------------------------------------------------------------------
    @Override
    public void destroy() throws DestructionException {
        client = new RackspaceRestClient();
        try {
            client.authenticate(creds.getUser(), creds.getApiKey());
            env.destroy();
        } catch (AuthenticationException e) {
            log.error("Authentication failed. Cannot destroy environment.");
            throw new DestructionException(e);
        }
    }

    //----------------------------------------------------------------------------------------------
    @Override
    public void restore() throws RestorationException {
        // TODO Rackspace update commands
    }

    //----------------------------------------------------------------------------------------------
    @Override
    public void setCredentials(Credentials credentials)
            throws CredentialsException {
        this.creds = (CredentialsRackspace) credentials;
    }

    //----------------------------------------------------------------------------------------------
    @Override
    public EnvironmentTask getEnvironment() {
        return env;
    }

    //----------------------------------------------------------------------------------------------
    @Override
    public Credentials fetchCredentials() {
        return creds;
    }

    //----------------------------------------------------------------------------------------------
    public EnvironmentTaskRackspace createEnvironment() {
        this.env = new EnvironmentTaskRackspace(this);
        return this.env;
    }

}
