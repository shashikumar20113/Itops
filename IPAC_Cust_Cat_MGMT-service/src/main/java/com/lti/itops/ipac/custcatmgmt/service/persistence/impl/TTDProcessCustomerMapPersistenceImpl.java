/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.lti.itops.ipac.custcatmgmt.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDProcessCustomerMapException;
import com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap;
import com.lti.itops.ipac.custcatmgmt.model.impl.TTDProcessCustomerMapImpl;
import com.lti.itops.ipac.custcatmgmt.model.impl.TTDProcessCustomerMapModelImpl;
import com.lti.itops.ipac.custcatmgmt.service.persistence.TTDProcessCustomerMapPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the ttd process customer map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sunprabh
 * @see TTDProcessCustomerMapPersistence
 * @see com.lti.itops.ipac.custcatmgmt.service.persistence.TTDProcessCustomerMapUtil
 * @generated
 */
@ProviderType
public class TTDProcessCustomerMapPersistenceImpl extends BasePersistenceImpl<TTDProcessCustomerMap>
	implements TTDProcessCustomerMapPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TTDProcessCustomerMapUtil} to access the ttd process customer map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TTDProcessCustomerMapImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TTDProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDProcessCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TTDProcessCustomerMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TTDProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDProcessCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TTDProcessCustomerMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TTDProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDProcessCustomerMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONID =
		new FinderPath(TTDProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDProcessCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TTDProcessCustomerMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByorganizationId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID =
		new FinderPath(TTDProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDProcessCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TTDProcessCustomerMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByorganizationId",
			new String[] { Long.class.getName() },
			TTDProcessCustomerMapModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGANIZATIONID = new FinderPath(TTDProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDProcessCustomerMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByorganizationId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the ttd process customer maps where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching ttd process customer maps
	 */
	@Override
	public List<TTDProcessCustomerMap> findByorganizationId(long organizationId) {
		return findByorganizationId(organizationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ttd process customer maps where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDProcessCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of ttd process customer maps
	 * @param end the upper bound of the range of ttd process customer maps (not inclusive)
	 * @return the range of matching ttd process customer maps
	 */
	@Override
	public List<TTDProcessCustomerMap> findByorganizationId(
		long organizationId, int start, int end) {
		return findByorganizationId(organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ttd process customer maps where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDProcessCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of ttd process customer maps
	 * @param end the upper bound of the range of ttd process customer maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ttd process customer maps
	 */
	@Override
	public List<TTDProcessCustomerMap> findByorganizationId(
		long organizationId, int start, int end,
		OrderByComparator<TTDProcessCustomerMap> orderByComparator) {
		return findByorganizationId(organizationId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ttd process customer maps where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDProcessCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of ttd process customer maps
	 * @param end the upper bound of the range of ttd process customer maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching ttd process customer maps
	 */
	@Override
	public List<TTDProcessCustomerMap> findByorganizationId(
		long organizationId, int start, int end,
		OrderByComparator<TTDProcessCustomerMap> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID;
			finderArgs = new Object[] { organizationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONID;
			finderArgs = new Object[] {
					organizationId,
					
					start, end, orderByComparator
				};
		}

		List<TTDProcessCustomerMap> list = null;

		if (retrieveFromCache) {
			list = (List<TTDProcessCustomerMap>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TTDProcessCustomerMap ttdProcessCustomerMap : list) {
					if ((organizationId != ttdProcessCustomerMap.getOrganizationId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TTDPROCESSCUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TTDProcessCustomerMapModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				if (!pagination) {
					list = (List<TTDProcessCustomerMap>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TTDProcessCustomerMap>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first ttd process customer map in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ttd process customer map
	 * @throws NoSuchTTDProcessCustomerMapException if a matching ttd process customer map could not be found
	 */
	@Override
	public TTDProcessCustomerMap findByorganizationId_First(
		long organizationId,
		OrderByComparator<TTDProcessCustomerMap> orderByComparator)
		throws NoSuchTTDProcessCustomerMapException {
		TTDProcessCustomerMap ttdProcessCustomerMap = fetchByorganizationId_First(organizationId,
				orderByComparator);

		if (ttdProcessCustomerMap != null) {
			return ttdProcessCustomerMap;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append("}");

		throw new NoSuchTTDProcessCustomerMapException(msg.toString());
	}

	/**
	 * Returns the first ttd process customer map in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ttd process customer map, or <code>null</code> if a matching ttd process customer map could not be found
	 */
	@Override
	public TTDProcessCustomerMap fetchByorganizationId_First(
		long organizationId,
		OrderByComparator<TTDProcessCustomerMap> orderByComparator) {
		List<TTDProcessCustomerMap> list = findByorganizationId(organizationId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ttd process customer map in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ttd process customer map
	 * @throws NoSuchTTDProcessCustomerMapException if a matching ttd process customer map could not be found
	 */
	@Override
	public TTDProcessCustomerMap findByorganizationId_Last(
		long organizationId,
		OrderByComparator<TTDProcessCustomerMap> orderByComparator)
		throws NoSuchTTDProcessCustomerMapException {
		TTDProcessCustomerMap ttdProcessCustomerMap = fetchByorganizationId_Last(organizationId,
				orderByComparator);

		if (ttdProcessCustomerMap != null) {
			return ttdProcessCustomerMap;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append("}");

		throw new NoSuchTTDProcessCustomerMapException(msg.toString());
	}

	/**
	 * Returns the last ttd process customer map in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ttd process customer map, or <code>null</code> if a matching ttd process customer map could not be found
	 */
	@Override
	public TTDProcessCustomerMap fetchByorganizationId_Last(
		long organizationId,
		OrderByComparator<TTDProcessCustomerMap> orderByComparator) {
		int count = countByorganizationId(organizationId);

		if (count == 0) {
			return null;
		}

		List<TTDProcessCustomerMap> list = findByorganizationId(organizationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ttd process customer maps before and after the current ttd process customer map in the ordered set where organizationId = &#63;.
	 *
	 * @param TTDProcessCustomerId the primary key of the current ttd process customer map
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ttd process customer map
	 * @throws NoSuchTTDProcessCustomerMapException if a ttd process customer map with the primary key could not be found
	 */
	@Override
	public TTDProcessCustomerMap[] findByorganizationId_PrevAndNext(
		long TTDProcessCustomerId, long organizationId,
		OrderByComparator<TTDProcessCustomerMap> orderByComparator)
		throws NoSuchTTDProcessCustomerMapException {
		TTDProcessCustomerMap ttdProcessCustomerMap = findByPrimaryKey(TTDProcessCustomerId);

		Session session = null;

		try {
			session = openSession();

			TTDProcessCustomerMap[] array = new TTDProcessCustomerMapImpl[3];

			array[0] = getByorganizationId_PrevAndNext(session,
					ttdProcessCustomerMap, organizationId, orderByComparator,
					true);

			array[1] = ttdProcessCustomerMap;

			array[2] = getByorganizationId_PrevAndNext(session,
					ttdProcessCustomerMap, organizationId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TTDProcessCustomerMap getByorganizationId_PrevAndNext(
		Session session, TTDProcessCustomerMap ttdProcessCustomerMap,
		long organizationId,
		OrderByComparator<TTDProcessCustomerMap> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TTDPROCESSCUSTOMERMAP_WHERE);

		query.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TTDProcessCustomerMapModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organizationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ttdProcessCustomerMap);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTDProcessCustomerMap> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ttd process customer maps where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	@Override
	public void removeByorganizationId(long organizationId) {
		for (TTDProcessCustomerMap ttdProcessCustomerMap : findByorganizationId(
				organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ttdProcessCustomerMap);
		}
	}

	/**
	 * Returns the number of ttd process customer maps where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching ttd process customer maps
	 */
	@Override
	public int countByorganizationId(long organizationId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORGANIZATIONID;

		Object[] finderArgs = new Object[] { organizationId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TTDPROCESSCUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2 = "ttdProcessCustomerMap.organizationId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_TTDPROCESSID = new FinderPath(TTDProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDProcessCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TTDProcessCustomerMapImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByTTDProcessId",
			new String[] { Long.class.getName(), Long.class.getName() },
			TTDProcessCustomerMapModelImpl.TTDPROCESSID_COLUMN_BITMASK |
			TTDProcessCustomerMapModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TTDPROCESSID = new FinderPath(TTDProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDProcessCustomerMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTTDProcessId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the ttd process customer map where TTDProcessId = &#63; and organizationId = &#63; or throws a {@link NoSuchTTDProcessCustomerMapException} if it could not be found.
	 *
	 * @param TTDProcessId the ttd process ID
	 * @param organizationId the organization ID
	 * @return the matching ttd process customer map
	 * @throws NoSuchTTDProcessCustomerMapException if a matching ttd process customer map could not be found
	 */
	@Override
	public TTDProcessCustomerMap findByTTDProcessId(long TTDProcessId,
		long organizationId) throws NoSuchTTDProcessCustomerMapException {
		TTDProcessCustomerMap ttdProcessCustomerMap = fetchByTTDProcessId(TTDProcessId,
				organizationId);

		if (ttdProcessCustomerMap == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("TTDProcessId=");
			msg.append(TTDProcessId);

			msg.append(", organizationId=");
			msg.append(organizationId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchTTDProcessCustomerMapException(msg.toString());
		}

		return ttdProcessCustomerMap;
	}

	/**
	 * Returns the ttd process customer map where TTDProcessId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param TTDProcessId the ttd process ID
	 * @param organizationId the organization ID
	 * @return the matching ttd process customer map, or <code>null</code> if a matching ttd process customer map could not be found
	 */
	@Override
	public TTDProcessCustomerMap fetchByTTDProcessId(long TTDProcessId,
		long organizationId) {
		return fetchByTTDProcessId(TTDProcessId, organizationId, true);
	}

	/**
	 * Returns the ttd process customer map where TTDProcessId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param TTDProcessId the ttd process ID
	 * @param organizationId the organization ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching ttd process customer map, or <code>null</code> if a matching ttd process customer map could not be found
	 */
	@Override
	public TTDProcessCustomerMap fetchByTTDProcessId(long TTDProcessId,
		long organizationId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { TTDProcessId, organizationId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_TTDPROCESSID,
					finderArgs, this);
		}

		if (result instanceof TTDProcessCustomerMap) {
			TTDProcessCustomerMap ttdProcessCustomerMap = (TTDProcessCustomerMap)result;

			if ((TTDProcessId != ttdProcessCustomerMap.getTTDProcessId()) ||
					(organizationId != ttdProcessCustomerMap.getOrganizationId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TTDPROCESSCUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_TTDPROCESSID_TTDPROCESSID_2);

			query.append(_FINDER_COLUMN_TTDPROCESSID_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(TTDProcessId);

				qPos.add(organizationId);

				List<TTDProcessCustomerMap> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_TTDPROCESSID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"TTDProcessCustomerMapPersistenceImpl.fetchByTTDProcessId(long, long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TTDProcessCustomerMap ttdProcessCustomerMap = list.get(0);

					result = ttdProcessCustomerMap;

					cacheResult(ttdProcessCustomerMap);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_TTDPROCESSID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (TTDProcessCustomerMap)result;
		}
	}

	/**
	 * Removes the ttd process customer map where TTDProcessId = &#63; and organizationId = &#63; from the database.
	 *
	 * @param TTDProcessId the ttd process ID
	 * @param organizationId the organization ID
	 * @return the ttd process customer map that was removed
	 */
	@Override
	public TTDProcessCustomerMap removeByTTDProcessId(long TTDProcessId,
		long organizationId) throws NoSuchTTDProcessCustomerMapException {
		TTDProcessCustomerMap ttdProcessCustomerMap = findByTTDProcessId(TTDProcessId,
				organizationId);

		return remove(ttdProcessCustomerMap);
	}

	/**
	 * Returns the number of ttd process customer maps where TTDProcessId = &#63; and organizationId = &#63;.
	 *
	 * @param TTDProcessId the ttd process ID
	 * @param organizationId the organization ID
	 * @return the number of matching ttd process customer maps
	 */
	@Override
	public int countByTTDProcessId(long TTDProcessId, long organizationId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TTDPROCESSID;

		Object[] finderArgs = new Object[] { TTDProcessId, organizationId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TTDPROCESSCUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_TTDPROCESSID_TTDPROCESSID_2);

			query.append(_FINDER_COLUMN_TTDPROCESSID_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(TTDProcessId);

				qPos.add(organizationId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TTDPROCESSID_TTDPROCESSID_2 = "ttdProcessCustomerMap.TTDProcessId = ? AND ";
	private static final String _FINDER_COLUMN_TTDPROCESSID_ORGANIZATIONID_2 = "ttdProcessCustomerMap.organizationId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_TTDPROCESSCUSTOMERID = new FinderPath(TTDProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDProcessCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TTDProcessCustomerMapImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByTTDProcessCustomerId",
			new String[] { Long.class.getName(), Long.class.getName() },
			TTDProcessCustomerMapModelImpl.TTDPROCESSCUSTOMERID_COLUMN_BITMASK |
			TTDProcessCustomerMapModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TTDPROCESSCUSTOMERID = new FinderPath(TTDProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDProcessCustomerMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTTDProcessCustomerId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the ttd process customer map where TTDProcessCustomerId = &#63; and organizationId = &#63; or throws a {@link NoSuchTTDProcessCustomerMapException} if it could not be found.
	 *
	 * @param TTDProcessCustomerId the ttd process customer ID
	 * @param organizationId the organization ID
	 * @return the matching ttd process customer map
	 * @throws NoSuchTTDProcessCustomerMapException if a matching ttd process customer map could not be found
	 */
	@Override
	public TTDProcessCustomerMap findByTTDProcessCustomerId(
		long TTDProcessCustomerId, long organizationId)
		throws NoSuchTTDProcessCustomerMapException {
		TTDProcessCustomerMap ttdProcessCustomerMap = fetchByTTDProcessCustomerId(TTDProcessCustomerId,
				organizationId);

		if (ttdProcessCustomerMap == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("TTDProcessCustomerId=");
			msg.append(TTDProcessCustomerId);

			msg.append(", organizationId=");
			msg.append(organizationId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchTTDProcessCustomerMapException(msg.toString());
		}

		return ttdProcessCustomerMap;
	}

	/**
	 * Returns the ttd process customer map where TTDProcessCustomerId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param TTDProcessCustomerId the ttd process customer ID
	 * @param organizationId the organization ID
	 * @return the matching ttd process customer map, or <code>null</code> if a matching ttd process customer map could not be found
	 */
	@Override
	public TTDProcessCustomerMap fetchByTTDProcessCustomerId(
		long TTDProcessCustomerId, long organizationId) {
		return fetchByTTDProcessCustomerId(TTDProcessCustomerId,
			organizationId, true);
	}

	/**
	 * Returns the ttd process customer map where TTDProcessCustomerId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param TTDProcessCustomerId the ttd process customer ID
	 * @param organizationId the organization ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching ttd process customer map, or <code>null</code> if a matching ttd process customer map could not be found
	 */
	@Override
	public TTDProcessCustomerMap fetchByTTDProcessCustomerId(
		long TTDProcessCustomerId, long organizationId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { TTDProcessCustomerId, organizationId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_TTDPROCESSCUSTOMERID,
					finderArgs, this);
		}

		if (result instanceof TTDProcessCustomerMap) {
			TTDProcessCustomerMap ttdProcessCustomerMap = (TTDProcessCustomerMap)result;

			if ((TTDProcessCustomerId != ttdProcessCustomerMap.getTTDProcessCustomerId()) ||
					(organizationId != ttdProcessCustomerMap.getOrganizationId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TTDPROCESSCUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_TTDPROCESSCUSTOMERID_TTDPROCESSCUSTOMERID_2);

			query.append(_FINDER_COLUMN_TTDPROCESSCUSTOMERID_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(TTDProcessCustomerId);

				qPos.add(organizationId);

				List<TTDProcessCustomerMap> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_TTDPROCESSCUSTOMERID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"TTDProcessCustomerMapPersistenceImpl.fetchByTTDProcessCustomerId(long, long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TTDProcessCustomerMap ttdProcessCustomerMap = list.get(0);

					result = ttdProcessCustomerMap;

					cacheResult(ttdProcessCustomerMap);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_TTDPROCESSCUSTOMERID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (TTDProcessCustomerMap)result;
		}
	}

	/**
	 * Removes the ttd process customer map where TTDProcessCustomerId = &#63; and organizationId = &#63; from the database.
	 *
	 * @param TTDProcessCustomerId the ttd process customer ID
	 * @param organizationId the organization ID
	 * @return the ttd process customer map that was removed
	 */
	@Override
	public TTDProcessCustomerMap removeByTTDProcessCustomerId(
		long TTDProcessCustomerId, long organizationId)
		throws NoSuchTTDProcessCustomerMapException {
		TTDProcessCustomerMap ttdProcessCustomerMap = findByTTDProcessCustomerId(TTDProcessCustomerId,
				organizationId);

		return remove(ttdProcessCustomerMap);
	}

	/**
	 * Returns the number of ttd process customer maps where TTDProcessCustomerId = &#63; and organizationId = &#63;.
	 *
	 * @param TTDProcessCustomerId the ttd process customer ID
	 * @param organizationId the organization ID
	 * @return the number of matching ttd process customer maps
	 */
	@Override
	public int countByTTDProcessCustomerId(long TTDProcessCustomerId,
		long organizationId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TTDPROCESSCUSTOMERID;

		Object[] finderArgs = new Object[] { TTDProcessCustomerId, organizationId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TTDPROCESSCUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_TTDPROCESSCUSTOMERID_TTDPROCESSCUSTOMERID_2);

			query.append(_FINDER_COLUMN_TTDPROCESSCUSTOMERID_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(TTDProcessCustomerId);

				qPos.add(organizationId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TTDPROCESSCUSTOMERID_TTDPROCESSCUSTOMERID_2 =
		"ttdProcessCustomerMap.TTDProcessCustomerId = ? AND ";
	private static final String _FINDER_COLUMN_TTDPROCESSCUSTOMERID_ORGANIZATIONID_2 =
		"ttdProcessCustomerMap.organizationId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_PROCESSCUSTOMERMAP = new FinderPath(TTDProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDProcessCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TTDProcessCustomerMapImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByProcessCustomerMap",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			TTDProcessCustomerMapModelImpl.ORGANIZATIONID_COLUMN_BITMASK |
			TTDProcessCustomerMapModelImpl.TTDPROCESSID_COLUMN_BITMASK |
			TTDProcessCustomerMapModelImpl.STATUSID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROCESSCUSTOMERMAP = new FinderPath(TTDProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDProcessCustomerMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProcessCustomerMap",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns the ttd process customer map where organizationId = &#63; and TTDProcessId = &#63; and statusId = &#63; or throws a {@link NoSuchTTDProcessCustomerMapException} if it could not be found.
	 *
	 * @param organizationId the organization ID
	 * @param TTDProcessId the ttd process ID
	 * @param statusId the status ID
	 * @return the matching ttd process customer map
	 * @throws NoSuchTTDProcessCustomerMapException if a matching ttd process customer map could not be found
	 */
	@Override
	public TTDProcessCustomerMap findByProcessCustomerMap(long organizationId,
		long TTDProcessId, int statusId)
		throws NoSuchTTDProcessCustomerMapException {
		TTDProcessCustomerMap ttdProcessCustomerMap = fetchByProcessCustomerMap(organizationId,
				TTDProcessId, statusId);

		if (ttdProcessCustomerMap == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("organizationId=");
			msg.append(organizationId);

			msg.append(", TTDProcessId=");
			msg.append(TTDProcessId);

			msg.append(", statusId=");
			msg.append(statusId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchTTDProcessCustomerMapException(msg.toString());
		}

		return ttdProcessCustomerMap;
	}

	/**
	 * Returns the ttd process customer map where organizationId = &#63; and TTDProcessId = &#63; and statusId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param organizationId the organization ID
	 * @param TTDProcessId the ttd process ID
	 * @param statusId the status ID
	 * @return the matching ttd process customer map, or <code>null</code> if a matching ttd process customer map could not be found
	 */
	@Override
	public TTDProcessCustomerMap fetchByProcessCustomerMap(
		long organizationId, long TTDProcessId, int statusId) {
		return fetchByProcessCustomerMap(organizationId, TTDProcessId,
			statusId, true);
	}

	/**
	 * Returns the ttd process customer map where organizationId = &#63; and TTDProcessId = &#63; and statusId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param organizationId the organization ID
	 * @param TTDProcessId the ttd process ID
	 * @param statusId the status ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching ttd process customer map, or <code>null</code> if a matching ttd process customer map could not be found
	 */
	@Override
	public TTDProcessCustomerMap fetchByProcessCustomerMap(
		long organizationId, long TTDProcessId, int statusId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] {
				organizationId, TTDProcessId, statusId
			};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_PROCESSCUSTOMERMAP,
					finderArgs, this);
		}

		if (result instanceof TTDProcessCustomerMap) {
			TTDProcessCustomerMap ttdProcessCustomerMap = (TTDProcessCustomerMap)result;

			if ((organizationId != ttdProcessCustomerMap.getOrganizationId()) ||
					(TTDProcessId != ttdProcessCustomerMap.getTTDProcessId()) ||
					(statusId != ttdProcessCustomerMap.getStatusId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_TTDPROCESSCUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_PROCESSCUSTOMERMAP_ORGANIZATIONID_2);

			query.append(_FINDER_COLUMN_PROCESSCUSTOMERMAP_TTDPROCESSID_2);

			query.append(_FINDER_COLUMN_PROCESSCUSTOMERMAP_STATUSID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				qPos.add(TTDProcessId);

				qPos.add(statusId);

				List<TTDProcessCustomerMap> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_PROCESSCUSTOMERMAP,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"TTDProcessCustomerMapPersistenceImpl.fetchByProcessCustomerMap(long, long, int, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TTDProcessCustomerMap ttdProcessCustomerMap = list.get(0);

					result = ttdProcessCustomerMap;

					cacheResult(ttdProcessCustomerMap);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_PROCESSCUSTOMERMAP,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (TTDProcessCustomerMap)result;
		}
	}

	/**
	 * Removes the ttd process customer map where organizationId = &#63; and TTDProcessId = &#63; and statusId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @param TTDProcessId the ttd process ID
	 * @param statusId the status ID
	 * @return the ttd process customer map that was removed
	 */
	@Override
	public TTDProcessCustomerMap removeByProcessCustomerMap(
		long organizationId, long TTDProcessId, int statusId)
		throws NoSuchTTDProcessCustomerMapException {
		TTDProcessCustomerMap ttdProcessCustomerMap = findByProcessCustomerMap(organizationId,
				TTDProcessId, statusId);

		return remove(ttdProcessCustomerMap);
	}

	/**
	 * Returns the number of ttd process customer maps where organizationId = &#63; and TTDProcessId = &#63; and statusId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param TTDProcessId the ttd process ID
	 * @param statusId the status ID
	 * @return the number of matching ttd process customer maps
	 */
	@Override
	public int countByProcessCustomerMap(long organizationId,
		long TTDProcessId, int statusId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROCESSCUSTOMERMAP;

		Object[] finderArgs = new Object[] {
				organizationId, TTDProcessId, statusId
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_TTDPROCESSCUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_PROCESSCUSTOMERMAP_ORGANIZATIONID_2);

			query.append(_FINDER_COLUMN_PROCESSCUSTOMERMAP_TTDPROCESSID_2);

			query.append(_FINDER_COLUMN_PROCESSCUSTOMERMAP_STATUSID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				qPos.add(TTDProcessId);

				qPos.add(statusId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PROCESSCUSTOMERMAP_ORGANIZATIONID_2 =
		"ttdProcessCustomerMap.organizationId = ? AND ";
	private static final String _FINDER_COLUMN_PROCESSCUSTOMERMAP_TTDPROCESSID_2 =
		"ttdProcessCustomerMap.TTDProcessId = ? AND ";
	private static final String _FINDER_COLUMN_PROCESSCUSTOMERMAP_STATUSID_2 = "ttdProcessCustomerMap.statusId = ?";

	public TTDProcessCustomerMapPersistenceImpl() {
		setModelClass(TTDProcessCustomerMap.class);
	}

	/**
	 * Caches the ttd process customer map in the entity cache if it is enabled.
	 *
	 * @param ttdProcessCustomerMap the ttd process customer map
	 */
	@Override
	public void cacheResult(TTDProcessCustomerMap ttdProcessCustomerMap) {
		entityCache.putResult(TTDProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDProcessCustomerMapImpl.class,
			ttdProcessCustomerMap.getPrimaryKey(), ttdProcessCustomerMap);

		finderCache.putResult(FINDER_PATH_FETCH_BY_TTDPROCESSID,
			new Object[] {
				ttdProcessCustomerMap.getTTDProcessId(),
				ttdProcessCustomerMap.getOrganizationId()
			}, ttdProcessCustomerMap);

		finderCache.putResult(FINDER_PATH_FETCH_BY_TTDPROCESSCUSTOMERID,
			new Object[] {
				ttdProcessCustomerMap.getTTDProcessCustomerId(),
				ttdProcessCustomerMap.getOrganizationId()
			}, ttdProcessCustomerMap);

		finderCache.putResult(FINDER_PATH_FETCH_BY_PROCESSCUSTOMERMAP,
			new Object[] {
				ttdProcessCustomerMap.getOrganizationId(),
				ttdProcessCustomerMap.getTTDProcessId(),
				ttdProcessCustomerMap.getStatusId()
			}, ttdProcessCustomerMap);

		ttdProcessCustomerMap.resetOriginalValues();
	}

	/**
	 * Caches the ttd process customer maps in the entity cache if it is enabled.
	 *
	 * @param ttdProcessCustomerMaps the ttd process customer maps
	 */
	@Override
	public void cacheResult(List<TTDProcessCustomerMap> ttdProcessCustomerMaps) {
		for (TTDProcessCustomerMap ttdProcessCustomerMap : ttdProcessCustomerMaps) {
			if (entityCache.getResult(
						TTDProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
						TTDProcessCustomerMapImpl.class,
						ttdProcessCustomerMap.getPrimaryKey()) == null) {
				cacheResult(ttdProcessCustomerMap);
			}
			else {
				ttdProcessCustomerMap.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ttd process customer maps.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TTDProcessCustomerMapImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ttd process customer map.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TTDProcessCustomerMap ttdProcessCustomerMap) {
		entityCache.removeResult(TTDProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDProcessCustomerMapImpl.class,
			ttdProcessCustomerMap.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((TTDProcessCustomerMapModelImpl)ttdProcessCustomerMap,
			true);
	}

	@Override
	public void clearCache(List<TTDProcessCustomerMap> ttdProcessCustomerMaps) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TTDProcessCustomerMap ttdProcessCustomerMap : ttdProcessCustomerMaps) {
			entityCache.removeResult(TTDProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
				TTDProcessCustomerMapImpl.class,
				ttdProcessCustomerMap.getPrimaryKey());

			clearUniqueFindersCache((TTDProcessCustomerMapModelImpl)ttdProcessCustomerMap,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		TTDProcessCustomerMapModelImpl ttdProcessCustomerMapModelImpl) {
		Object[] args = new Object[] {
				ttdProcessCustomerMapModelImpl.getTTDProcessId(),
				ttdProcessCustomerMapModelImpl.getOrganizationId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_TTDPROCESSID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_TTDPROCESSID, args,
			ttdProcessCustomerMapModelImpl, false);

		args = new Object[] {
				ttdProcessCustomerMapModelImpl.getTTDProcessCustomerId(),
				ttdProcessCustomerMapModelImpl.getOrganizationId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_TTDPROCESSCUSTOMERID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_TTDPROCESSCUSTOMERID, args,
			ttdProcessCustomerMapModelImpl, false);

		args = new Object[] {
				ttdProcessCustomerMapModelImpl.getOrganizationId(),
				ttdProcessCustomerMapModelImpl.getTTDProcessId(),
				ttdProcessCustomerMapModelImpl.getStatusId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_PROCESSCUSTOMERMAP, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_PROCESSCUSTOMERMAP, args,
			ttdProcessCustomerMapModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		TTDProcessCustomerMapModelImpl ttdProcessCustomerMapModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					ttdProcessCustomerMapModelImpl.getTTDProcessId(),
					ttdProcessCustomerMapModelImpl.getOrganizationId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TTDPROCESSID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_TTDPROCESSID, args);
		}

		if ((ttdProcessCustomerMapModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TTDPROCESSID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					ttdProcessCustomerMapModelImpl.getOriginalTTDProcessId(),
					ttdProcessCustomerMapModelImpl.getOriginalOrganizationId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TTDPROCESSID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_TTDPROCESSID, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
					ttdProcessCustomerMapModelImpl.getTTDProcessCustomerId(),
					ttdProcessCustomerMapModelImpl.getOrganizationId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TTDPROCESSCUSTOMERID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_TTDPROCESSCUSTOMERID,
				args);
		}

		if ((ttdProcessCustomerMapModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TTDPROCESSCUSTOMERID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					ttdProcessCustomerMapModelImpl.getOriginalTTDProcessCustomerId(),
					ttdProcessCustomerMapModelImpl.getOriginalOrganizationId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TTDPROCESSCUSTOMERID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_TTDPROCESSCUSTOMERID,
				args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
					ttdProcessCustomerMapModelImpl.getOrganizationId(),
					ttdProcessCustomerMapModelImpl.getTTDProcessId(),
					ttdProcessCustomerMapModelImpl.getStatusId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROCESSCUSTOMERMAP,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PROCESSCUSTOMERMAP,
				args);
		}

		if ((ttdProcessCustomerMapModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PROCESSCUSTOMERMAP.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					ttdProcessCustomerMapModelImpl.getOriginalOrganizationId(),
					ttdProcessCustomerMapModelImpl.getOriginalTTDProcessId(),
					ttdProcessCustomerMapModelImpl.getOriginalStatusId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROCESSCUSTOMERMAP,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PROCESSCUSTOMERMAP,
				args);
		}
	}

	/**
	 * Creates a new ttd process customer map with the primary key. Does not add the ttd process customer map to the database.
	 *
	 * @param TTDProcessCustomerId the primary key for the new ttd process customer map
	 * @return the new ttd process customer map
	 */
	@Override
	public TTDProcessCustomerMap create(long TTDProcessCustomerId) {
		TTDProcessCustomerMap ttdProcessCustomerMap = new TTDProcessCustomerMapImpl();

		ttdProcessCustomerMap.setNew(true);
		ttdProcessCustomerMap.setPrimaryKey(TTDProcessCustomerId);

		ttdProcessCustomerMap.setCompanyId(companyProvider.getCompanyId());

		return ttdProcessCustomerMap;
	}

	/**
	 * Removes the ttd process customer map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param TTDProcessCustomerId the primary key of the ttd process customer map
	 * @return the ttd process customer map that was removed
	 * @throws NoSuchTTDProcessCustomerMapException if a ttd process customer map with the primary key could not be found
	 */
	@Override
	public TTDProcessCustomerMap remove(long TTDProcessCustomerId)
		throws NoSuchTTDProcessCustomerMapException {
		return remove((Serializable)TTDProcessCustomerId);
	}

	/**
	 * Removes the ttd process customer map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ttd process customer map
	 * @return the ttd process customer map that was removed
	 * @throws NoSuchTTDProcessCustomerMapException if a ttd process customer map with the primary key could not be found
	 */
	@Override
	public TTDProcessCustomerMap remove(Serializable primaryKey)
		throws NoSuchTTDProcessCustomerMapException {
		Session session = null;

		try {
			session = openSession();

			TTDProcessCustomerMap ttdProcessCustomerMap = (TTDProcessCustomerMap)session.get(TTDProcessCustomerMapImpl.class,
					primaryKey);

			if (ttdProcessCustomerMap == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTTDProcessCustomerMapException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ttdProcessCustomerMap);
		}
		catch (NoSuchTTDProcessCustomerMapException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected TTDProcessCustomerMap removeImpl(
		TTDProcessCustomerMap ttdProcessCustomerMap) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ttdProcessCustomerMap)) {
				ttdProcessCustomerMap = (TTDProcessCustomerMap)session.get(TTDProcessCustomerMapImpl.class,
						ttdProcessCustomerMap.getPrimaryKeyObj());
			}

			if (ttdProcessCustomerMap != null) {
				session.delete(ttdProcessCustomerMap);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ttdProcessCustomerMap != null) {
			clearCache(ttdProcessCustomerMap);
		}

		return ttdProcessCustomerMap;
	}

	@Override
	public TTDProcessCustomerMap updateImpl(
		TTDProcessCustomerMap ttdProcessCustomerMap) {
		boolean isNew = ttdProcessCustomerMap.isNew();

		if (!(ttdProcessCustomerMap instanceof TTDProcessCustomerMapModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ttdProcessCustomerMap.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(ttdProcessCustomerMap);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ttdProcessCustomerMap proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TTDProcessCustomerMap implementation " +
				ttdProcessCustomerMap.getClass());
		}

		TTDProcessCustomerMapModelImpl ttdProcessCustomerMapModelImpl = (TTDProcessCustomerMapModelImpl)ttdProcessCustomerMap;

		Session session = null;

		try {
			session = openSession();

			if (ttdProcessCustomerMap.isNew()) {
				session.save(ttdProcessCustomerMap);

				ttdProcessCustomerMap.setNew(false);
			}
			else {
				ttdProcessCustomerMap = (TTDProcessCustomerMap)session.merge(ttdProcessCustomerMap);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!TTDProcessCustomerMapModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					ttdProcessCustomerMapModelImpl.getOrganizationId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((ttdProcessCustomerMapModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ttdProcessCustomerMapModelImpl.getOriginalOrganizationId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
					args);

				args = new Object[] {
						ttdProcessCustomerMapModelImpl.getOrganizationId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
					args);
			}
		}

		entityCache.putResult(TTDProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDProcessCustomerMapImpl.class,
			ttdProcessCustomerMap.getPrimaryKey(), ttdProcessCustomerMap, false);

		clearUniqueFindersCache(ttdProcessCustomerMapModelImpl, false);
		cacheUniqueFindersCache(ttdProcessCustomerMapModelImpl);

		ttdProcessCustomerMap.resetOriginalValues();

		return ttdProcessCustomerMap;
	}

	/**
	 * Returns the ttd process customer map with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ttd process customer map
	 * @return the ttd process customer map
	 * @throws NoSuchTTDProcessCustomerMapException if a ttd process customer map with the primary key could not be found
	 */
	@Override
	public TTDProcessCustomerMap findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTTDProcessCustomerMapException {
		TTDProcessCustomerMap ttdProcessCustomerMap = fetchByPrimaryKey(primaryKey);

		if (ttdProcessCustomerMap == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTTDProcessCustomerMapException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return ttdProcessCustomerMap;
	}

	/**
	 * Returns the ttd process customer map with the primary key or throws a {@link NoSuchTTDProcessCustomerMapException} if it could not be found.
	 *
	 * @param TTDProcessCustomerId the primary key of the ttd process customer map
	 * @return the ttd process customer map
	 * @throws NoSuchTTDProcessCustomerMapException if a ttd process customer map with the primary key could not be found
	 */
	@Override
	public TTDProcessCustomerMap findByPrimaryKey(long TTDProcessCustomerId)
		throws NoSuchTTDProcessCustomerMapException {
		return findByPrimaryKey((Serializable)TTDProcessCustomerId);
	}

	/**
	 * Returns the ttd process customer map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ttd process customer map
	 * @return the ttd process customer map, or <code>null</code> if a ttd process customer map with the primary key could not be found
	 */
	@Override
	public TTDProcessCustomerMap fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TTDProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
				TTDProcessCustomerMapImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		TTDProcessCustomerMap ttdProcessCustomerMap = (TTDProcessCustomerMap)serializable;

		if (ttdProcessCustomerMap == null) {
			Session session = null;

			try {
				session = openSession();

				ttdProcessCustomerMap = (TTDProcessCustomerMap)session.get(TTDProcessCustomerMapImpl.class,
						primaryKey);

				if (ttdProcessCustomerMap != null) {
					cacheResult(ttdProcessCustomerMap);
				}
				else {
					entityCache.putResult(TTDProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
						TTDProcessCustomerMapImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TTDProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
					TTDProcessCustomerMapImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return ttdProcessCustomerMap;
	}

	/**
	 * Returns the ttd process customer map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param TTDProcessCustomerId the primary key of the ttd process customer map
	 * @return the ttd process customer map, or <code>null</code> if a ttd process customer map with the primary key could not be found
	 */
	@Override
	public TTDProcessCustomerMap fetchByPrimaryKey(long TTDProcessCustomerId) {
		return fetchByPrimaryKey((Serializable)TTDProcessCustomerId);
	}

	@Override
	public Map<Serializable, TTDProcessCustomerMap> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TTDProcessCustomerMap> map = new HashMap<Serializable, TTDProcessCustomerMap>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			TTDProcessCustomerMap ttdProcessCustomerMap = fetchByPrimaryKey(primaryKey);

			if (ttdProcessCustomerMap != null) {
				map.put(primaryKey, ttdProcessCustomerMap);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(TTDProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
					TTDProcessCustomerMapImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (TTDProcessCustomerMap)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TTDPROCESSCUSTOMERMAP_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (TTDProcessCustomerMap ttdProcessCustomerMap : (List<TTDProcessCustomerMap>)q.list()) {
				map.put(ttdProcessCustomerMap.getPrimaryKeyObj(),
					ttdProcessCustomerMap);

				cacheResult(ttdProcessCustomerMap);

				uncachedPrimaryKeys.remove(ttdProcessCustomerMap.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TTDProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
					TTDProcessCustomerMapImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the ttd process customer maps.
	 *
	 * @return the ttd process customer maps
	 */
	@Override
	public List<TTDProcessCustomerMap> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ttd process customer maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDProcessCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ttd process customer maps
	 * @param end the upper bound of the range of ttd process customer maps (not inclusive)
	 * @return the range of ttd process customer maps
	 */
	@Override
	public List<TTDProcessCustomerMap> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ttd process customer maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDProcessCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ttd process customer maps
	 * @param end the upper bound of the range of ttd process customer maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ttd process customer maps
	 */
	@Override
	public List<TTDProcessCustomerMap> findAll(int start, int end,
		OrderByComparator<TTDProcessCustomerMap> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ttd process customer maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDProcessCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ttd process customer maps
	 * @param end the upper bound of the range of ttd process customer maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of ttd process customer maps
	 */
	@Override
	public List<TTDProcessCustomerMap> findAll(int start, int end,
		OrderByComparator<TTDProcessCustomerMap> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<TTDProcessCustomerMap> list = null;

		if (retrieveFromCache) {
			list = (List<TTDProcessCustomerMap>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TTDPROCESSCUSTOMERMAP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TTDPROCESSCUSTOMERMAP;

				if (pagination) {
					sql = sql.concat(TTDProcessCustomerMapModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TTDProcessCustomerMap>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TTDProcessCustomerMap>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the ttd process customer maps from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TTDProcessCustomerMap ttdProcessCustomerMap : findAll()) {
			remove(ttdProcessCustomerMap);
		}
	}

	/**
	 * Returns the number of ttd process customer maps.
	 *
	 * @return the number of ttd process customer maps
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TTDPROCESSCUSTOMERMAP);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TTDProcessCustomerMapModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ttd process customer map persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(TTDProcessCustomerMapImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_TTDPROCESSCUSTOMERMAP = "SELECT ttdProcessCustomerMap FROM TTDProcessCustomerMap ttdProcessCustomerMap";
	private static final String _SQL_SELECT_TTDPROCESSCUSTOMERMAP_WHERE_PKS_IN = "SELECT ttdProcessCustomerMap FROM TTDProcessCustomerMap ttdProcessCustomerMap WHERE TTDProcessCustomerId IN (";
	private static final String _SQL_SELECT_TTDPROCESSCUSTOMERMAP_WHERE = "SELECT ttdProcessCustomerMap FROM TTDProcessCustomerMap ttdProcessCustomerMap WHERE ";
	private static final String _SQL_COUNT_TTDPROCESSCUSTOMERMAP = "SELECT COUNT(ttdProcessCustomerMap) FROM TTDProcessCustomerMap ttdProcessCustomerMap";
	private static final String _SQL_COUNT_TTDPROCESSCUSTOMERMAP_WHERE = "SELECT COUNT(ttdProcessCustomerMap) FROM TTDProcessCustomerMap ttdProcessCustomerMap WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ttdProcessCustomerMap.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TTDProcessCustomerMap exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TTDProcessCustomerMap exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(TTDProcessCustomerMapPersistenceImpl.class);
}