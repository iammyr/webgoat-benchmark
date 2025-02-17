/**
 * OWASP Benchmark Project
 *
 * This file is part of the Open Web Application Security Project (OWASP)
 * Benchmark Project For details, please see
 * <a href="https://www.owasp.org/index.php/Benchmark">https://www.owasp.org/index.php/Benchmark</a>.
 *
 * The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
 * of the GNU General Public License as published by the Free Software Foundation, version 2.
 *
 * The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details
 *
 * @author Dave Wichers <a href="https://www.aspectsecurity.com">Aspect Security</a>
 * @created 2015
 */

package org.owasp.benchmark.score.parsers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Reader {

    public Node getNamedNode(String name, NodeList list) {
        for (int i = 0; i < list.getLength(); i++) {
            Node n = list.item(i);
            if (n.getNodeName().equals(name)) {
                return n;
            }
        }
        return null;
    }

    public List<Node> getNamedChildren(String name, List<Node> list) {
        List<Node> results = new ArrayList<Node>();
        for (Node n : list) {
            NodeList children = n.getChildNodes();
            for ( int i=0; i<children.getLength(); i++ ) {
                Node child = children.item(i);
                if (child.getNodeName().equals(name)) {
                    // System.out.println("> " + child.getNodeName() + "::" + child.getNodeValue());
                    results.add(child);
                }
            }
        }
        return results;
    }

    public List<Node> getNamedNodes(String name, NodeList list) {
        List<Node> results = new ArrayList<Node>();
        for (int i = 0; i < list.getLength(); i++) {
            Node n = list.item(i);
            if (n.getNodeName().equals(name)) {
                // System.out.println(">> " + n.getNodeName() + "::" + n.getNodeValue());
                results.add(n);
            }
        }
        return results;
    }

    public String getAttributeValue(String name, Node node) {
        if (node == null)
            return null;
        NamedNodeMap nnm = node.getAttributes();
        if (nnm != null) {
            Node attrnode = nnm.getNamedItem(name);
            if (attrnode != null) {
                String value = attrnode.getNodeValue();
                return value;
            }
        }
        return null;
    } 
    
}