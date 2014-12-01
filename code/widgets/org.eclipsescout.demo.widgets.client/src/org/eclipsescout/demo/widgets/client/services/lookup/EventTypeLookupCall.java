/**
 *
 */
package org.eclipsescout.demo.widgets.client.services.lookup;

import org.eclipse.scout.rt.shared.services.common.code.ICode;
import org.eclipse.scout.rt.shared.services.lookup.CodeLookupCall;
import org.eclipse.scout.rt.shared.services.lookup.ICodeLookupCallVisitor;
import org.eclipsescout.demo.widgets.shared.services.code.EventTypeCodeType;
import java.util.List;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.shared.services.lookup.ILookupRow;

/**
 * @author mzi
 */
public class EventTypeLookupCall extends CodeLookupCall<Long> {

  private static final long serialVersionUID = 1L;

  @Override
  protected List<? extends ILookupRow<Long>> execCreateLookupRows() throws ProcessingException {
    //TODO [mzi] Auto-generated method stub.
    return super.execCreateLookupRows();
  }

  /**
   * Visitor class that filters out inactive codes.
   */
  class LookupVisitor implements ICodeLookupCallVisitor<Long> {

    @Override
    public boolean visit(CodeLookupCall<Long> call, ICode<Long> code, int treeLevel) {
      return code.isActive();
    }
  }

  /**
   * Default constructor that wires this lookup call to the event type code type.
   */
  public EventTypeLookupCall() {
    super(EventTypeCodeType.class);
    setFilter(new LookupVisitor());
  }
}
