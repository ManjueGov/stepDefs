package com.testvagrant.stepdefs.core;


import com.testvagrant.stepdefs.core.events.Event;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.testvagrant.stepdefs.core.events.EventCodes.*;
import static com.testvagrant.stepdefs.core.events.EventLookup.eventLookup;
import static com.testvagrant.stepdefs.helpers.AssertHelper.assertHelper;
import static com.testvagrant.stepdefs.helpers.ClickHelper.clickHelper;
import static com.testvagrant.stepdefs.helpers.TypeHelper.typeHelper;

public class Tavern {

    private Event event;
    private WebElement element;
    private String value;
    private WebDriver driver;
    private By by;

    private Tavern(WebDriver driver) {
        this.driver = driver;
    }

    public static Tavern tavern(WebDriver driver) {
        return new Tavern(driver);
    }

    public Tavern event(Event event) {
        this.event = event;
        return this;
    }

    public Tavern element(WebElement element) {
        this.element = element;
        return this;
    }

    public Tavern value(String value) {
        this.value = value;
        return this;
    }


    void serve(WebElement element) {
        this.element = element;
        int eventValue = getEventValue(event.getEventCode());
        switch (eventLookup().load().getEvent(eventValue)) {
            case TYPE:
                serveType();
                break;
            case CLICK:
                serveClick();
                break;
        }

    }

    private void serveClick() {
        switch(event.getEventCode()) {
            case CLICK_CODE:
                clickHelper(driver).click(element);
                break;
            case DOUBLE_CLICK_CODE:
                clickHelper(driver).doubleClick(element);
                break;
        }
    }

    public void serve(By targetBy) {
        this.by = targetBy;
        int eventValue = getEventValue(event.getEventCode());
        switch (eventLookup().load().getEvent(eventValue)) {
            case ASSERT:
                serveAssert();
                break;
        }
    }

    private void serveAssert() {
        switch (event.getEventCode()) {
            case ASSERT_IS_DISPLAYED_CODE:
                assertHelper(driver).isTextDisplayed(by, value);
                break;
            case ASSERT_IS_NOT_DISPLAYED_CODE:
                assertHelper(driver).isTextNotDisplayed(by, value);
                break;
            case ASSERT_IS_ENABLED_CODE:
                assertHelper(driver).isEnabled(by);
                break;
            case ASSERT_IS_NOT_ENABLED_CODE:
                assertHelper(driver).isNotEnabled(by);
                break;
        }
    }


    private void serveType() {
        switch (event.getEventCode()) {
            case TYPE_CODE:
                typeHelper(driver).onElement(element).type(value);
                break;
        }
    }


    private int getEventValue(String event) {
        return Integer.valueOf(event, 2);
    }


}
